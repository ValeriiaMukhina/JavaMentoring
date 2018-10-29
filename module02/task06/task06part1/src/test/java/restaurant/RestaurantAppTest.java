package restaurant;

import restaurant.client.Client;
import restaurant.food.FoodType;
import restaurant.food.extras.ExtrasType;
import restaurant.kitchen.Chef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantAppTest {
    private final Chef chef = new Chef();

    @Test
    public void hotDogIncreasesClientHappinessByTwo() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.HotDog);
        chef.prepare();
        //Then
        assertEquals(2, client.getHappiness(), 0.001);

    }

    @Test
    public void chipsIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.Chips);
        chef.prepare();
        //Then
        assertEquals(1.05, client.getHappiness(), 0.001);

    }

    @Test
    public void chipsWithKetchupIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.Chips, ExtrasType.Ketchup);
        chef.prepare();
        //Then
        assertEquals(2.1, client.getHappiness(), 0.001);
    }

    @Test
    public void chipsWithMustardIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.Chips, ExtrasType.Mustard);
        chef.prepare();
        //Then
        assertEquals(1, client.getHappiness(), 0.001);
    }

    @Test
    public void hotdogWithMustardIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.HotDog, ExtrasType.Mustard);
        chef.prepare();
        //Then
        assertEquals(1, client.getHappiness(), 0.001);
    }

    @Test
    public void hotdogWithKetchupIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.HotDog, ExtrasType.Ketchup);
        chef.prepare();
        //Then
        assertEquals(4, client.getHappiness(), 0.001);
    }
}