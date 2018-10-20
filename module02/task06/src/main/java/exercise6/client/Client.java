package exercise6.client;

import exercise6.food.extras.ExtraType;
import exercise6.food.FoodType;
import exercise6.food.Meal;
import exercise6.kitchen.Subject;
import exercise6.restaurant.FinishedOrderQueue;
import exercise6.restaurant.Order;
import exercise6.restaurant.PendingOrderQueue;

public class Client implements ObservableClient {

    private String name;

    private double happiness;

    public Client(String name, double initialHappiness) {
        this.name = name;
        this.happiness = initialHappiness;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getHappiness() {
        return happiness;
    }

    private void eat(Meal meal) {
        System.out.println(name + " happiness before is " + happiness);
        happiness = meal.increaseHappiness(happiness);
        System.out.println(name + " new happiness is " + happiness);
    }

    @Override
    public void update(Subject subject) {
        String name = subject.getUpdate();
        if (name.contains(this.name)) {
            System.out.println(this.name + " : My order is ready!!! I'm starting to eat.");
            eat(FinishedOrderQueue.getReadyOrderFromQueue());
        }
    }

    public void placeOrder(FoodType foodToOrder) {
        PendingOrderQueue.placeOrderToTheQueue(new Order(this, foodToOrder));

    }

    public void placeOrder(FoodType foodToOrder, ExtraType extra) {
        PendingOrderQueue.placeOrderToTheQueue(new Order(this, foodToOrder, extra));
    }
}