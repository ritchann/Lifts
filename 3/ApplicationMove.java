package JavaClasswork.Lesson1.Lesson7;

public class ApplicationMove {
    private int currentFloor;
    private int finalFloor;
    private Direction direction;

    public ApplicationMove(int currentFloor, int finalFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.finalFloor = finalFloor;
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getFinalFloor() {
        return finalFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
