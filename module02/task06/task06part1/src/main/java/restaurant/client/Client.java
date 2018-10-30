package restaurant.client;

import java.util.Objects;
import restaurant.food.FoodType;
import restaurant.food.Meal;
import restaurant.food.extras.ExtrasType;
import restaurant.kitchen.Subject;
import restaurant.order.FinishedOrderQueue;
import restaurant.order.Order;
import restaurant.order.PendingOrderQueue;

/**
 * @author Valeriia Biruk
 * @version 1.0
 */
public class Client implements ObservableClient {

    private final String name;

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
        System.out.println(this.name + " : My order is ready!!! I'm starting to eat.");
        eat(FinishedOrderQueue.getReadyOrderFromQueue());
    }

    public void placeOrder(FoodType foodToOrder) {
        PendingOrderQueue.placeOrderToTheQueue(new Order(this, foodToOrder));

    }

    public void placeOrder(FoodType foodToOrder, ExtrasType extra) {
        PendingOrderQueue.placeOrderToTheQueue(new Order(this, foodToOrder, extra));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return Double.compare(client.getHappiness(), getHappiness()) == 0 &&
                Objects.equals(getName(), client.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHappiness());
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", happiness=" + happiness +
                '}';
    }
}
