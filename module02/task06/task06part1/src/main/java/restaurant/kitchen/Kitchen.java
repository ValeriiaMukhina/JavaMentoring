package restaurant.kitchen;

import restaurant.food.*;
import restaurant.food.extras.*;

class Kitchen {

    static Cooker getCooker(FoodType foodType) {
        switch (foodType) {
            case Chips:
                return new ChipsCooker();
            case HotDog:
                return new HotDogCooker();
            default:
                throw new UnsupportedOperationException("We cannot cook this meal");
        }

    }

    static Sauce addSauce(ExtrasType type, Meal meal) {
        switch (type) {
            case Ketchup:
                return new Ketchup(meal);
            case Mustard:
                return new Mustard(meal);
            default:
                throw new UnsupportedOperationException("We cannot cook this meal");
        }
    }
}