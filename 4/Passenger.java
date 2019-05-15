package JavaClasswork.Lesson1.Lesson7;

public class Passenger {
    private int initialFloor;
    private int finalFloor;
    private int weight;
    private Direction direction;

    public Passenger(int initialFloor, int finalFloor, int weight,Direction direction) {
        this.initialFloor = initialFloor;
        this.finalFloor = finalFloor;
        this.weight = weight;
        this.direction=direction;
    }

    public int getInitialFloor() {
        return initialFloor;
    }

    public int getFinalFloor() {
        return finalFloor;
    }

    public int getWeight() {
        return weight;
    }

    public Direction getDirection() {
        return direction;
    }
}
