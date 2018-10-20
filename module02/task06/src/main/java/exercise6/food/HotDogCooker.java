package exercise6.food;

public class HotDogCooker implements Cooker {


    @Override
    public Meal cookMeal() {
        return new HotDog();
    }
}
