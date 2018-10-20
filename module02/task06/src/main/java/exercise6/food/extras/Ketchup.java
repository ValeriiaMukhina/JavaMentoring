package exercise6.food.extras;

import exercise6.food.Meal;

public class Ketchup extends Sauce {
    public Ketchup(Meal meal) {
        super(meal);
    }

    @Override
    public double increaseHappiness(double happiness) {
        return super.increaseHappiness(happiness) * 2;
    }
}
