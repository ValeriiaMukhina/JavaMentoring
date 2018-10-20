package exercise6.food;

public class ChipsCooker implements Cooker {
    @Override
    public Meal cookMeal() {
        return new Chips();
    }
}
