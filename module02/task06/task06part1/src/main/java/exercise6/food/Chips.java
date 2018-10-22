package exercise6.food;

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
