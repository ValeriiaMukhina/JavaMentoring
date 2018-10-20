package exercise6.restaurant;

import exercise6.food.Meal;

import java.util.LinkedList;

public class FinishedOrderQueue {

    private static final LinkedList<Meal> finishedOrders = new LinkedList<>();

    public static void placeOrderToTheQueue(Meal meal) {
        finishedOrders.add(meal);
    }

    public static Meal getReadyOrderFromQueue() {
        return finishedOrders.poll();
    }

}