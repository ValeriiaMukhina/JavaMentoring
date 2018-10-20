package exercise6.food.extras;

import exercise6.food.Meal;

public class Sauce implements Meal {

    protected Meal meal;

    public Sauce(Meal meal) {
        this.meal = meal;
    }

    @Override
    public double increaseHappiness(double happiness) {
        return meal.increaseHappiness(happiness);
    }
}
