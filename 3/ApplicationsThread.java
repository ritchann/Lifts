package JavaClasswork.Lesson1.Lesson7;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApplicationsThread extends Thread {
    //private CopyOnWriteArrayList<CopyOnWriteArrayList<Passenger>> applications=new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Passenger> applicationsUp=new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Passenger> applicationsDown=new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                Thread.sleep(random.nextInt(9001)+2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int initialFloor=random.nextInt(10);
            int finalFloor=random.nextInt(10);
            if(finalFloor==initialFloor){
                while (finalFloor==initialFloor) {
                    finalFloor = random.nextInt(10);
                }
            }

            Direction direction;
            if(initialFloor<finalFloor)
                direction=Direction.up;
            else
                direction=Direction.down;

            Passenger newPassenger=new Passenger(initialFloor,finalFloor,random.nextInt(61)+40,direction);

            if(direction.equals(Direction.up)) {
                applicationsUp.add(newPassenger);
                Collections.sort(applicationsUp, (o1, o2) -> {
                    if (o1.getInitialFloor() < o2.getInitialFloor())
                        return -1;
                    else {
                        if (o1.getInitialFloor() > o2.getInitialFloor())
                            return 1;
                        else
                            return 0;
                    }
                });
            }

            if(direction.equals(Direction.down)) {
                applicationsDown.add(newPassenger);
                Collections.sort(applicationsDown, (o1, o2) -> {
                    if (o1.getInitialFloor() < o2.getInitialFloor())
                        return -1;
                    else {
                        if (o1.getInitialFloor() > o2.getInitialFloor())
                            return 1;
                        else
                            return 0;
                    }
                });
            }
           System.out.println("NEW PASSENGER , initial floor = "+newPassenger.getInitialFloor()+" , final floor = "+newPassenger.getFinalFloor()+" , weight = "+newPassenger.getWeight());
        }
    }

    public CopyOnWriteArrayList<Passenger> getApplicationsUp() {
        return applicationsUp;
    }

    public CopyOnWriteArrayList<Passenger> getApplicationsDown() {
        return applicationsDown;
    }
}

