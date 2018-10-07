package com.epam.exercises.circularbuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;

public class CircularBuffer<T> {

    private static Logger LOGGER = LoggerFactory.getLogger(CircularBuffer.class);

    private Object[] elementData;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    public CircularBuffer(int capacity) {
        if (capacity > 0) {
            this.elementData = new Object[capacity];
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public void put(T t) {
        if ((head == tail) && (size == capacity)) {
            throw new RuntimeException("Circular buffer is full. You cannot insert an element.");
        }
        elementData[head] = t;
        head = (head + 1) % capacity;
        size++;

        LOGGER.info("----Element {} is added to the Circular Buffer. Buffer contains {} elementData: {}",
                    t, size, this.toString());
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {} \n", tail);
    }

    @SuppressWarnings("unchecked")
    public T get() {
        if (isEmpty()) {
            throw new RuntimeException("Circular buffer is empty. You cannot get an element.");
        }

        T element = (T) elementData[tail];
        elementData[tail] = null;
        tail = (tail + 1) % capacity;
        size--;

        LOGGER.info("----- You get element {} from the buffer the Circular Buffer. " +
                    "Buffer contains {} elements: {} --------",
                    element, size, this.toString());
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {}  ---------\n", tail);

        return element;
    }

    public Object[] toObjectArray() {
        Object[] array = new Object[size];

        if (tail < head) {
            System.arraycopy(elementData, tail, array, 0, size);
        } else if (tail >= head) {
            System.arraycopy(elementData, tail, array, 0, (capacity - tail));
            System.arraycopy(elementData, 0, array, (capacity - tail), head);
        }

        LOGGER.info("ObjectArray: {}  --------\n", Arrays.toString(array));

        return array;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class c) {
        final T[] array = (T[]) Array.newInstance(c, size);
        Object[] objectArray = toObjectArray();

        for (int i = 0; i < size; i++) {
            array[i] = (T) objectArray[i];
        }

        LOGGER.info("Array : {}  --------\n", Arrays.toString(array));
        return array;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] objectArray = toObjectArray();
        return (T[]) Arrays.copyOf(objectArray, size);
    }

    @SuppressWarnings("unchecked")
    public List<T> asList() {
        List<T> list = new LinkedList<>();

        if (tail < head) {
            for (int i = tail; i < head; i++) {
                list.add((T) elementData[i]);
            }
        } else if (tail >= head) {
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
       elementData = new Object[size];
       size = 0;
        tail = head = 0;
       addAll(list);
        LOGGER.info("Sorted elementData in Circular Buffer : {}  --------", this.toString());
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {}  ---------\n", tail);
    }

    @SuppressWarnings("unchecked")
    public void sort2(Comparator<? super T> comparator) {
        Arrays.sort((T[])elementData, tail, head, comparator);
        LOGGER.info("Sorted elementData in Circular Buffer : {}  --------", this.toString());
        LOGGER.info("The head of the Circular Buffer is {}", head);
        LOGGER.info("The tail of the Circular Buffer is {}  ---------\n", tail);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public Object[] getElementData() {
        return elementData;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}