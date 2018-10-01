package com.epam.exercises.circularbuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircularBuffer<T extends Comparable<T>> {

    private static Logger LOGGER = LoggerFactory.getLogger(CircularBuffer.class);
    private static final Object[] EMPTY_ELEMENTDATA = {};


    private Object[] elementData;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    public CircularBuffer(int capacity) {
        if (capacity > 0) {
            this.elementData = new Object[capacity];
        } else if (capacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
        this.capacity = capacity;
    }

    public void put(T t) {
        if (head == tail && size == capacity) {
            throw new RuntimeException("Circular buffer is full. You cannot insert an element.");
        }
        elementData[head] = t;
        head = (head + 1) % capacity;
        size++;
        LOGGER.info("----Element {} is added to the Circular Buffer. Buffer contains {} elementData", t, size);
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {} \n", tail);
    }

    @SuppressWarnings("unchecked")
    public T get() {
        if (head == tail && size != capacity) {
            throw new RuntimeException("Circular buffer is full. You cannot insert an element.");
        }
        T element = (T) elementData[tail];
        elementData[tail] = null;
        tail = (tail + 1) % capacity;
        size--;
        LOGGER.info("----- You get element {} from the buffer the Circular Buffer. Buffer contains {} elements: {} --------", element, size, this.toString());
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {}  ---------\n", tail);
        return element;
    }

    public Object[] toObjectArray() {
        Object[] array = new Object[size];
        if(tail < head) {
            for (int i = tail; i < head; i++) {
                array[i] = elementData[i];
            }
        }
        else if(head <= tail) {
            for (int i = tail; i < capacity; i++) {
                array[i] = elementData[i];
            }
            for (int i = 0; i < head; i++) {
                array[i] = elementData[i];
            }
        }
        LOGGER.info("ObjectArray: {}  --------\n", array);
        return array;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        if(tail < head) {
            for (int i = tail; i < head; i++) {
                array[i] = (T) elementData[i];
            }
        }
        else if(head <= tail) {
            for (int i = tail; i < capacity; i++) {
                array[i] = (T) elementData[i];
            }
            for (int i = 0; i < head; i++) {
                array[i] = (T) elementData[i];
            }
        }
        LOGGER.info("Array : {}  --------\n", array);
        return array;
    }

    @SuppressWarnings("unchecked")
    public List<T> asList() {
        List<T> list = new ArrayList<>();
        if(tail < head) {
            for (int i = tail; i < head; i++) {
                list.add((T) elementData[i]);
            }
        }
        else if(head <= tail) {
            for (int i = tail; i < capacity; i++) {
                list.add((T) elementData[i]);
            }
            for (int i = 0; i < head; i++) {
                list.add((T) elementData[i]);
            }
        }
        LOGGER.info("List : {}  --------\n", list);
        return list;
    }

    public void addAll(List<? extends T> toAdd) {
        if (toAdd.size() > (capacity - size)) {
            throw new RuntimeException("There is not enough free space in the buffer to add all elementData.");
        }
        for (T t : toAdd) {
            this.put(t);
        }
    }

    public void sort(Comparator<? super T> comparator) {
        List<T> list = this.asList();
        list.sort(comparator);
        elementData = new Object[capacity];
        size = 0;
        tail = head = 0;
        addAll(list);
        LOGGER.info("Sorted elementData in Circular Buffer : {}  --------", list);
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {}  ---------\n", tail);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        if(tail < head) {
            for (int i = tail; i < head ; i++) {
                list.add((T) elementData[i]);
            }
        }
        else if(head <= tail) {
            for (int i = tail; i < capacity; i++) {
                list.add((T) elementData[i]);
            }
            for (int i = 0; i < head; i++) {
                list.add((T) elementData[i]);
            }
        }
        return list.toString();
    }
}