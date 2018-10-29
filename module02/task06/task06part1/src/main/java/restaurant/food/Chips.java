package restaurant.food;

/**
 * The order sells hot dogs and chips.
 *
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class Chips implements Meal {

    @Override
    public double increaseHappiness(double happiness) {
         return happiness + happiness * 0.05;
    }

    @Override
    public String toString() {
        return "Chips{}";
    }
}
