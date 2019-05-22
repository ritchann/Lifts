package JavaClasswork.Lesson1.Lesson7;

import java.util.concurrent.CopyOnWriteArrayList;

public class Lift {
    private int numberLift;
    private int weightInLift;
    private int currentFloor;
    private int finalFloor;
    private boolean move;
    private Direction direction;
    private CopyOnWriteArrayList<Integer> listForDrawing=new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Integer> listFloors=new CopyOnWriteArrayList<>();

    public Lift(int numberLift)  {
        this.numberLift=numberLift;
        this.currentFloor = 0;
        this.finalFloor=0;
        this.direction=Direction.inPlace;
        this.move=true;

       listFloors.add(0);
    }


    public void setWeightInLift(int weightInLift) {
        this.weightInLift = weightInLift;
    }

    public int getWeightInLift() {
        return weightInLift;
    }


    public void setListFloors(CopyOnWriteArrayList<Integer> listFloors) {
        this.listFloors = listFloors;
    }

    public CopyOnWriteArrayList<Integer> getListFloors() {
        return listFloors;
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setFinalFloor(int finalFloor) {
        this.finalFloor = finalFloor;
    }

    public CopyOnWriteArrayList<Integer> getListForDrawing() {
        return listForDrawing;
    }

    public boolean getMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}

