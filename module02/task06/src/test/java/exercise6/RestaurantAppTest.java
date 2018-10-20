package exercise6;

import exercise6.client.Client;
import exercise6.food.FoodType;
import exercise6.food.extras.ExtraType;
import exercise6.kitchen.Chef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantAppTest {
    Chef chef = new Chef();

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
    public void ChipsIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.Chips);
        chef.prepare();
        //Then
        assertEquals(1.05, client.getHappiness(), 0.001);

    }

    @Test
    public void ChipsWithKetchupIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.Chips, ExtraType.Ketchup);
        chef.prepare();
        //Then
        assertEquals(2.1, client.getHappiness(), 0.001);
    }

    @Test
    public void ChipsWithMustardIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.Chips, ExtraType.Mustard);
        chef.prepare();
        //Then
        assertEquals(1, client.getHappiness(), 0.001);
    }

    @Test
    public void HotdogWithMustardIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.HotDog, ExtraType.Mustard);
        chef.prepare();
        //Then
        assertEquals(1, client.getHappiness(), 0.001);
    }

    @Test
    public void HotdogWithKetchupIncreasesClientHappiness() {
        //Given
        Client client = new Client("Test Client", 1);
        // When
        client.placeOrder(FoodType.HotDog, ExtraType.Ketchup);
        chef.prepare();
        //Then
        assertEquals(4, client.getHappiness(), 0.001);
    }
}
