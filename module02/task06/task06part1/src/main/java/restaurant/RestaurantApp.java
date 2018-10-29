package restaurant;

import restaurant.client.Client;
import restaurant.food.FoodType;
import restaurant.food.extras.ExtrasType;
import restaurant.kitchen.Chef;

class RestaurantApp {
    public static void main(String[] args) {
        Client alex = new Client("Alex", 1);
        Client viktor = new Client("Viktor", 1);
        Client lera = new Client("Lera", 2);
        Client gorg = new Client("Gorg", 2);

        alex.placeOrder(FoodType.Chips);
        viktor.placeOrder(FoodType.Chips);
        lera.placeOrder(FoodType.HotDog);
        gorg.placeOrder(FoodType.Chips, ExtrasType.Ketchup);

        Chef chef = new Chef();
        chef.prepare();
    }
}