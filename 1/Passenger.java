package JavaClasswork.Lesson1.Lesson7;

public class Passenger {
    private int initialFloor;
    private int finalFloor;
    private int weight;

    public Passenger(int initialFloor, int finalFloor, int weight) {
        this.initialFloor = initialFloor;
        this.finalFloor = finalFloor;
        this.weight = weight;
    }

    public int getInitialFloor() {
        return initialFloor;
    }

    public void setInitialFloor(int initialFloor) {
        this.initialFloor = initialFloor;
    }

    public int getFinalFloor() {
        return finalFloor;
    }

    public void setFinalFloor(int finalFloor) {
        this.finalFloor = finalFloor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
