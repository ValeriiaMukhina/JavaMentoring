package restaurant.food.extras;

import restaurant.food.Meal;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class Ketchup extends Sauce {
    public Ketchup(Meal meal) {
        super(meal);
    }

    @Override
    public double increaseHappiness(double happiness) {
        return super.increaseHappiness(happiness) * 2;
    }

    @Override
    public String toString() {
        return "Ketchup";
    }
}
