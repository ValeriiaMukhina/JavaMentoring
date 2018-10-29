package exercise6.kitchen;

import exercise6.restaurant.FinishedOrderQueue;
import exercise6.restaurant.Order;
import exercise6.restaurant.PendingOrderQueue;
import exercise6.client.ObservableClient;
import exercise6.food.Meal;

import java.util.ArrayList;
import java.util.List;

public class Chef implements Subject {

    //TODO: it looks like Set<> is more reasonable to use instead of List here
    private final List<ObservableClient> clientsToNotify;

    //TODO: Fields: message, mealIsReady - it would be better to create separate class to store Order status.
    // They have no sense as instance fields of Chef class and might cause an issue withing multithreaded environment.
    private String message;
    private boolean mealIsReady;

    //TODO: not clear the purpose of this MUTEX object here
    private final Object MUTEX= new Object();

    public Chef(){
        this.clientsToNotify =new ArrayList<>();
    }

    @Override
    public void register(ObservableClient client) {
        //TODO: replace with Objects.requireNonNull(client, "Null Observer")
        if(client == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!clientsToNotify.contains(client)) clientsToNotify.add(client);
        }
    }

    //TODO: this method is not used anywhere. Why do you need it?
    @Override
    public void unregister(ObservableClient obj) {
        synchronized (MUTEX) {
            clientsToNotify.remove(obj);
        }
    }

    //TODO: actually you don't need to store list of all clients
    //Particular client whose order is ready we can get from the order
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