package JavaClasswork.Lesson1.Lesson7;

import javafx.application.Application;

public class LiftManager extends Thread {
    Lift[] lifts=new Lift[3];
    Applications applications=new Applications();
    ProcessDrawing processDrawing=new ProcessDrawing();

    public LiftManager(){
        for (int i = 0; i <3 ; i++) {
            lifts[i]=new Lift();
            lifts[i].start();
        }

        applications.start();
    }
    @Override
    public void run() {
        Application.launch(ProcessDrawing.class);
        while (true) {
            if (applications.getApplications().size()!=0) {
                for (int i = 0; i < 3; i++) {
                    if (lifts[i].getDirection().equals(Direction.inPlace)) {
                        System.out.println("Lift number of " + (i+1) + " move passenger on " + applications.getApplications().get(0).getInitialFloor() + " floor, to " + applications.getApplications().get(0).getFinalFloor() + " floor");
                        lifts[i].getApplications().add(applications.getApplications().get(0));
                        applications.getApplications().remove(0);
                        i = 3;//сделать в коассе лифт массив задач, чтобы в ран он пробегался по задачам и выолнял их
                    }

                    if(lifts[i].getMoveApp().size()>0){
                        if(lifts[i].getDirection().equals(Direction.up)){
                            try {
                                processDrawing.up(lifts[i].getMoveApp().get(0).getCurrentFloor(),lifts[i].getMoveApp().get(0).getFinalFloor(),i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            if(lifts[i].getDirection().equals(Direction.up)){
                                try {
                                    processDrawing.down(lifts[i].getMoveApp().get(0).getCurrentFloor(),lifts[i].getMoveApp().get(0).getFinalFloor(),i);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
