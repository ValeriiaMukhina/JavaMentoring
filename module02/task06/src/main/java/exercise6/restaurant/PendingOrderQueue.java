package exercise6.restaurant;

import exercise6.restaurant.Order;

import java.util.LinkedList;

public class PendingOrderQueue {

    private static LinkedList<Order> pendingOrders = new LinkedList<>();

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
