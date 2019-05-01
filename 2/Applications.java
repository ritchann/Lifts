package JavaClasswork.Lesson1.Lesson7;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Applications extends Thread {
    private CopyOnWriteArrayList<Passenger> applications = new CopyOnWriteArrayList<>();

    @Override
    public void run(){
        Random random=new Random();
        while (true){
            try {
                Thread.sleep(random.nextInt(9000+1)+1000);
                int initialFloor=random.nextInt(9+1);
                int finalFloor=random.nextInt(9+1);
                if(finalFloor==initialFloor){
                    while (finalFloor==initialFloor) {
                        finalFloor = random.nextInt(9 + 1);
                    }
                }
                int weight=random.nextInt(60+1)+40;
                Passenger newPassenger=new Passenger(initialFloor,finalFloor,weight);
                applications .add(newPassenger);
                System.out.println("NEW PASSENGER , initial floor = "+newPassenger.getInitialFloor()+" , final floor = "+newPassenger.getFinalFloor()+" , weight = "+newPassenger.getWeight());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public CopyOnWriteArrayList<Passenger> getApplications () {
        return applications ;
    }

    public void setApplications (CopyOnWriteArrayList<Passenger> applications ) {
        this.applications  = applications ;
    }
}
