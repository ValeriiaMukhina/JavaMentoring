package exercise6;

import exercise6.client.Client;
import exercise6.food.extras.ExtraType;
import exercise6.food.FoodType;
import exercise6.kitchen.Chef;

public class RestaurantApp
{
    public static void main( String[] args )
    {
        Client alex = new Client("Alex", 1);
        Client viktor = new Client("Viktor", 1);
        Client lera = new Client("Lera", 2);
        Client gorg = new Client("Gorg", 2);

        alex.placeOrder(FoodType.Chips);
        viktor.placeOrder(FoodType.Chips);
        lera.placeOrder(FoodType.HotDog);
        gorg.placeOrder(FoodType.Chips, ExtraType.Ketchup);

        Chef chef = new Chef();
        chef.prepare();
    }
}
