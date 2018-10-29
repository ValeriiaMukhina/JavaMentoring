package restaurant.order;

import java.util.LinkedList;
import java.util.Queue;
import restaurant.food.Meal;

/**
 * The orders are prepared by a robot one after another (FIFO).
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class FinishedOrderQueue {
    private static final Queue<Meal> finishedOrders = new LinkedList<>();

    public static void placeOrderToTheQueue(Meal meal) {
        finishedOrders.add(meal);
    }

    public static Meal getReadyOrderFromQueue() {
        return finishedOrders.poll();
    }
}