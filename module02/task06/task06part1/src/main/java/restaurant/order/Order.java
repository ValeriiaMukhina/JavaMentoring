package restaurant.order;

import java.util.Objects;
import restaurant.client.ObservableClient;
import restaurant.food.FoodType;
import restaurant.food.extras.ExtrasType;

/**
 * The order contains information about client, food and extra.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class Order {

    private final ObservableClient client;

    private final FoodType orderedFood;

    private ExtrasType extra;

    public Order(ObservableClient client, FoodType orderedFood) {
        this.client = client;
        this.orderedFood = orderedFood;
    }

    public Order(ObservableClient client, FoodType orderedFood, ExtrasType extrasType) {
        this.client = client;
        this.orderedFood = orderedFood;
        this.extra = extrasType;
    }

    public ObservableClient getClient() {
        return client;
    }

    public FoodType getOrderedFood() {
        return orderedFood;
    }

    public ExtrasType getExtra() {
        return extra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(getClient(), order.getClient()) &&
                getOrderedFood() == order.getOrderedFood() &&
                getExtra() == order.getExtra();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClient(), getOrderedFood(), getExtra());
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", orderedFood=" + orderedFood +
                ", extra=" + extra +
                '}';
    }
}
