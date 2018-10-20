package exercise6.food.extras;

import exercise6.food.Meal;

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
