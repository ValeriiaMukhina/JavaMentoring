package exercise6.restaurant;

import exercise6.client.ObservableClient;
import exercise6.food.extras.ExtrasType;
import exercise6.food.FoodType;

import java.util.Objects;

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
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
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