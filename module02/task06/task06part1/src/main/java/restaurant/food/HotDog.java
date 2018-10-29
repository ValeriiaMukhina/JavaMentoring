package restaurant.food;

/**
 * The order sells hot dogs and chips.
 *
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class HotDog implements Meal {


    @Override
    public double increaseHappiness(double happiness) {
           return happiness * 2;
    }

    @Override
    public String toString() {
        return "HotDog{}";
    }
}
