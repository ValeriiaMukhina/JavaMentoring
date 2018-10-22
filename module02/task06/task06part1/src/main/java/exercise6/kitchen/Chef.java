package exercise6.kitchen;

import exercise6.restaurant.FinishedOrderQueue;
import exercise6.restaurant.Order;
import exercise6.restaurant.PendingOrderQueue;
import exercise6.client.ObservableClient;
import exercise6.food.Meal;

import java.util.ArrayList;
import java.util.List;

public class Chef implements Subject {


    private final List<ObservableClient> clientsToNotify;
    private String message;
    private boolean mealIsReady;
    private final Object MUTEX= new Object();

    public Chef(){
        this.clientsToNotify =new ArrayList<>();
    }

    @Override
    public void register(ObservableClient client) {
        if(client == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!clientsToNotify.contains(client)) clientsToNotify.add(client);
        }
    }

    @Override
    public void unregister(ObservableClient obj) {
        synchronized (MUTEX) {
            clientsToNotify.remove(obj);
        }
    }



    @Override
    public void notifyOrderCompleted() {
        List<ObservableClient> clientsLocal;
        synchronized (MUTEX) {
            if (!mealIsReady)
                return;
            clientsLocal = new ArrayList<>(this.clientsToNotify);
            this.mealIsReady =false;
        }
        for (ObservableClient client : clientsLocal) {
            client.update(this);
        }
    }

    public String getUpdate() {
        return message;
    }

    public void prepare() {
        while (PendingOrderQueue.isNotEmpty()) {
            Order orderFromQueue = PendingOrderQueue.getOrderFromQueue();
            register(orderFromQueue.getClient());
            Meal meal = Kitchen.getCooker(orderFromQueue.getOrderedFood()).cookMeal();
            if (orderFromQueue.getExtra() != null) {
                meal = Kitchen.addSauce(orderFromQueue.getExtra(), meal);
            }

            FinishedOrderQueue.placeOrderToTheQueue(meal);
            this.message = orderFromQueue.getClient().getName();
            this.mealIsReady = true;
            notifyOrderCompleted();
        }
    }
}