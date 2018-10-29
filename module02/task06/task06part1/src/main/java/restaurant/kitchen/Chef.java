package restaurant.kitchen;

import restaurant.client.ObservableClient;
import restaurant.food.Meal;
import restaurant.order.FinishedOrderQueue;
import restaurant.order.Order;
import restaurant.order.PendingOrderQueue;

/**
 * Chef cooks meal and when it is ready notifies customer.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class Chef implements Subject {

    @Override
    public void notifyOrderCompleted(ObservableClient client) {
        client.update(this);
    }

    public void prepare() {
        while (PendingOrderQueue.isNotEmpty()) {
            Order orderFromQueue = PendingOrderQueue.getOrderFromQueue();
            Meal meal = Kitchen.getCooker(orderFromQueue.getOrderedFood()).cookMeal();
            if (orderFromQueue.getExtra() != null) {
                meal = Kitchen.addSauce(orderFromQueue.getExtra(), meal);
            }

            FinishedOrderQueue.placeOrderToTheQueue(meal);
            notifyOrderCompleted(orderFromQueue.getClient());
        }
    }
}
