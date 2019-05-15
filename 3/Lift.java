package JavaClasswork.Lesson1.Lesson7;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lift extends Thread {
    private int weightInLift;
    private int currentFloor;
    private int finalFloor;
    private Direction direction;
    private CopyOnWriteArrayList<Integer> weightPassengers=new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Integer> listFloors=new CopyOnWriteArrayList<>();

    public Lift()  {
        this.weightInLift=0;
        this.currentFloor = 0;
        this.finalFloor=0;
        this.direction=Direction.inPlace;
        for (int i = 0; i <10 ; i++) {
            weightPassengers.add(0);
        }
    }

    @Override
    public void run() {
        while(true){
            if(direction.equals(Direction.up)){
                currentFloor=0;
                finalFloor=9;

                for (int i = 0; i <=9 ; i++) {
                    Collections.sort(listFloors);
                    try {
                        while (listFloors.contains(i)){
                            while (listFloors.contains(i)) {
                                listFloors.remove(Integer.valueOf(i));
                                Thread.sleep(1000);
                            }
                            System.out.println("STOP LiftUP"+ i +" floor");
                        }
                        Collections.sort(listFloors);
                        if(i+1<=9) {
                            currentFloor = i + 1;
                            Thread.sleep(3000);

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                direction=Direction.down;
            }


            if (direction.equals(Direction.down)){
                currentFloor=9;
                finalFloor=0;

                for (int i = 9; i >=0 ; i--) {
                    Collections.sort(listFloors);
                    try {
                        while(listFloors.contains(i)){
                            while (listFloors.contains(i)) {
                                listFloors.remove(Integer.valueOf(i));
                                Thread.sleep(1000);
                            }
                            System.out.println("STOP LiftDOWN  "+ i +" floor");
                        }
                        Collections.sort(listFloors);
                        if(i-1>=0) {
                            currentFloor = i - 1;
                            Thread.sleep(3000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                direction=Direction.up;
            }
        }
    }

    public void setWeightInLift(int weightInLift) {
        this.weightInLift = weightInLift;
    }

    public int getWeightInLift() {
        return weightInLift;
    }

    public CopyOnWriteArrayList<Integer> getWeightPassengers() {
        return weightPassengers;
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
}
