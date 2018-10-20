package exercise6.restaurant;

import java.util.LinkedList;

public class PendingOrderQueue {

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