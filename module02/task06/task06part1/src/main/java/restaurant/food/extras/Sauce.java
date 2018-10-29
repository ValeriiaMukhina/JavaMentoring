package restaurant.food.extras;

import restaurant.food.Meal;

/**
 * Decorator pattern is used for extras.
 *
 * @author  Valeriia Biruk
 * @version 1.0
 */
public abstract class Sauce implements Meal {

    private final Meal meal;

    Sauce(Meal meal) {
        this.meal = meal;
    }

    @Override
    public double increaseHappiness(double happiness) {
        return meal.increaseHappiness(happiness);
    }
}