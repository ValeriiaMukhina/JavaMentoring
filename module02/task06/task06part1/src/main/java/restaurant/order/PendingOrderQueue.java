package restaurant.order;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The orders are prepared by a robot one after another (FIFO).
 *
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class PendingOrderQueue {

    private static final Queue<Order> pendingOrders = new LinkedList<>();

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