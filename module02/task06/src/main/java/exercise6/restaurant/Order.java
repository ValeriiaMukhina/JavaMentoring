package exercise6.restaurant;

import exercise6.client.ObservableClient;
import exercise6.food.extras.ExtraType;
import exercise6.food.FoodType;

public class Order {

    private ObservableClient client;

    private FoodType orderedFood;

    private ExtraType extra;

    public Order(ObservableClient client, FoodType orderedFood) {
        this.client = client;
        this.orderedFood = orderedFood;
    }

    public Order(ObservableClient client, FoodType orderedFood, ExtraType extraType) {
        this.client = client;
        this.orderedFood = orderedFood;
        this.extra = extraType;
    }

    public ObservableClient getClient() {
        return client;
    }

    public FoodType getOrderedFood() {
        return orderedFood;
    }

    public ExtraType getExtra() {
        return extra;
    }
}
