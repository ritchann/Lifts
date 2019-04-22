package JavaClasswork.Lesson1.Lesson7;

import java.util.concurrent.CopyOnWriteArrayList;

public class Lift extends Thread {
    private int countPassengers;
    private int currentFloor;
    private Direction direction;
    private int moveTime;
    private CopyOnWriteArrayList<Passenger> applications=new CopyOnWriteArrayList<>();

    public Lift()  {
        this.countPassengers = 0;
        this.currentFloor = 0;
        direction=Direction.inPlace;
    }


    public void move(Passenger passenger){
        int moveToCurrentFloorPassenger=Math.abs(passenger.getInitialFloor()-currentFloor);
        moveTime=Math.abs(passenger.getInitialFloor()-passenger.getFinalFloor());
        moveTime+=moveToCurrentFloorPassenger;
        currentFloor = applications.get(0).getFinalFloor();
        if(passenger.getFinalFloor()>passenger.getInitialFloor())
            direction=Direction.up;
        else
            direction=Direction.down;
    }

    @Override
    public void run(){
        while (true) {
            if (applications.size() != 0) {
                try {
                    move(applications.get(0));
                    Thread.sleep(3000 * moveTime);
                    direction = Direction.inPlace;
                    applications.remove(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public CopyOnWriteArrayList<Passenger> getApplications() {
        return applications;
    }

    public void setApplications(CopyOnWriteArrayList<Passenger> applications) {
        this.applications = applications;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
