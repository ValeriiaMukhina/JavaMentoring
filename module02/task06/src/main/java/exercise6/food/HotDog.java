package exercise6.food;

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
