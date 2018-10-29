package exercise6.restaurant;

import java.util.LinkedList;

public class PendingOrderQueue {

    //TODO: do not use exact types in definition: i.e. if you need a queue then define it with type Queue instead of LinkedList
    private static final LinkedList<Order> pendingOrders = new LinkedList<>();

    public static void placeOrderToTheQueue(Order order) {
        pendingOrders.add(order);
    }

    public static Order getOrderFromQueue() {
        return pendingOrders.poll();
    }

    public static boolean isNotEmpty() {
        return !pendingOrders.isEmpty();
    }
}