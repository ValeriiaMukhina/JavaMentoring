package restaurant.food;

/**
 * Factory Pattern is used for creating meals.
 *
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class HotDogCooker implements Cooker {

    @Override
    public Meal cookMeal() {
        return new HotDog();
    }
}