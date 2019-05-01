package JavaClasswork.Lesson1.Lesson7;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lift extends Thread {
    private int countPassengers;
    private int currentFloor;
    private Direction direction;
    private int moveTime;
    private CopyOnWriteArrayList<Passenger> applications;
    private CopyOnWriteArrayList<ApplicationMove> moveApp;


    public Lift()  {
        this.countPassengers = 0;
        this.currentFloor = 0;
        this.direction=Direction.inPlace;
        this.applications=new CopyOnWriteArrayList<>();
        this.moveApp=new CopyOnWriteArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            if (applications.size() != 0) {
                try {
                    move(applications.get(0));
                    applications.remove(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void move(Passenger pass) throws InterruptedException {
        int timeMove=Math.abs(currentFloor-pass.getInitialFloor());
        if(currentFloor>pass.getInitialFloor()){
            direction=Direction.down;
        }
        else {
            if(currentFloor<pass.getInitialFloor()){
                direction=Direction.up;
            }
            else {
                direction=Direction.inPlace;
            }
        }
        moveApp.add(new ApplicationMove(currentFloor,pass.getInitialFloor(),direction));
        System.out.println("Move from " +currentFloor +" to "+pass.getInitialFloor());
        Thread.sleep(timeMove*3000);
        currentFloor=pass.getInitialFloor();

        timeMove=Math.abs(pass.getInitialFloor()-pass.getFinalFloor());
        if(pass.getInitialFloor()>pass.getFinalFloor()){
            direction=Direction.down;
        }
        else {
            if(pass.getInitialFloor()<pass.getFinalFloor()){
                direction=Direction.up;
            }
            else {
                direction=Direction.inPlace;
            }
        }
        moveApp.add(new ApplicationMove(pass.getInitialFloor(),pass.getFinalFloor(),direction));
        System.out.println("Move from " +pass.getInitialFloor()+" to "+pass.getFinalFloor());
        Thread.sleep(timeMove*3000);
        currentFloor=pass.getFinalFloor();
        direction=Direction.inPlace;
    }

    public Direction getDirection() {
        return direction;
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }

    public CopyOnWriteArrayList<Passenger> getApplications() {
        return applications;
    }

    public void setApplications(CopyOnWriteArrayList<Passenger> applications) {
        this.applications = applications;
    }

    public CopyOnWriteArrayList<ApplicationMove> getMoveApp() {
        return moveApp;
    }
}
