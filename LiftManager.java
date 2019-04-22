package JavaClasswork.Lesson1.Lesson7;

public class LiftManager extends Thread {
    Lift[] lifts=new Lift[3];
    Applications applications=new Applications();

    public LiftManager(){
        for (int i = 0; i <3 ; i++) {
            lifts[i]=new Lift();
        }
    }
    @Override
    public void run() {
        applications.start();
        for (int i = 0; i <3 ; i++) {
            lifts[i].start();
        }
        while (true) {
            if (applications.getCopyOnWriteArrayList().size()!=0) {
                for (int i = 0; i < 3; i++) {
                    if (lifts[i].getDirection().equals(Direction.inPlace)) {
                        System.out.println("Lift number of " + (i+1) + " move passenger on " + applications.getCopyOnWriteArrayList().get(0).getInitialFloor() + " floor, to " + applications.getCopyOnWriteArrayList().get(0).getFinalFloor() + " floor");
                        lifts[i].getApplications().add(applications.getCopyOnWriteArrayList().get(0));
                        applications.getCopyOnWriteArrayList().remove(0);
                        i = 3;//сделать в коассе лифт массив задач, чтобы в ран он пробегался по задачам и выолнял их
                    }
                }
            }
        }
    }
}
