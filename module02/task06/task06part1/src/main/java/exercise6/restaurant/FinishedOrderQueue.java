package exercise6.restaurant;

import exercise6.food.Meal;

import java.util.LinkedList;

public class FinishedOrderQueue {
    //TODO: do not use exact types in definition: i.e. if you need a queue then define it with type Queue instead of LinkedList
    private static final LinkedList<Meal> finishedOrders = new LinkedList<>();

    public static void placeOrderToTheQueue(Meal meal) {
        finishedOrders.add(meal);
    }

    public static Meal getReadyOrderFromQueue() {
        return finishedOrders.poll();
    }

}