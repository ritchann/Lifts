package JavaClasswork.Lesson1.Lesson7;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lift extends Thread {
    private int weightInLift;
    private int currentFloor;
    private int finalFloor;
    private Direction direction;
    private CopyOnWriteArrayList<Integer> listForDrawing=new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Integer> listFloors=new CopyOnWriteArrayList<>();

    public Lift()  {
        this.currentFloor = 0;
        this.finalFloor=0;
        this.direction=Direction.inPlace;
    }

    @Override
    public void run() {
        while(true){
            if(direction.equals(Direction.up)){
                currentFloor=0;
                finalFloor=9;
                listFloors.add(0);
                listFloors.add(9);

                listForDrawing.add(0);

                for (int i = 0; i <=9 ; i++) {
                    Collections.sort(listFloors);
                    try {
                        while (listFloors.contains(i)){
                            while (listFloors.contains(i)) {
                                listFloors.remove(Integer.valueOf(i));
                                Thread.sleep(1000);
                            }
                            Collections.sort(listFloors);
                            if(!listForDrawing.contains(i)) {
                                listForDrawing.add(i);
                            }
                            System.out.println("STOP LiftUP"+ i +" floor");
                        }
                        Collections.sort(listFloors);
                        Collections.sort(listFloors);
                        if(i+1<=9) {
                            currentFloor = i + 1;
                            Thread.sleep(3000);
                            if(!listForDrawing.contains(9)) {
                                listForDrawing.add(9);
                            }
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

                listFloors.add(0);
                listFloors.add(9);
                Collections.sort(listFloors);

                listForDrawing.add(9);

                for (int i = 9; i >=0 ; i--) {
                    Collections.sort(listFloors);
                    Collections.sort(listFloors);
                    try {
                        while(listFloors.contains(i)){
                            while (listFloors.contains(i)) {
                                listFloors.remove(Integer.valueOf(i));
                                Thread.sleep(1000);
                            }
                            Collections.sort(listFloors);
                            if(!listForDrawing.contains(i)) {
                                listForDrawing.add(i);
                            }
                            System.out.println("STOP LiftDOWN  "+ i +" floor");
                        }
                        Collections.sort(listFloors);
                        Collections.sort(listFloors);
                        if(i-1>=0) {
                            currentFloor = i - 1;
                            Thread.sleep(3000);
                            if(!listForDrawing.contains(0)) {
                                listForDrawing.add(0);
                            }
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
}
