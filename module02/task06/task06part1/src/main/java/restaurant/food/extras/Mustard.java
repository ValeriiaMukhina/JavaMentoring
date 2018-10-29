package restaurant.food.extras;

import restaurant.food.Meal;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class Mustard extends Sauce {
    public Mustard(Meal meal) {
        super(meal);
    }

    @Override
    public double increaseHappiness(double happiness) {
        return happiness * 1;
    }

    @Override
    public String toString() {
        return "Mustard";
    }
}
