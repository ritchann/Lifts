package JavaClasswork.Lesson1.Lesson7;

import static JavaClasswork.Lesson1.Lesson7.LiftTest.AllMove;

public class LiftManager extends Thread {
    final int countLifts = 2;
    Lift[] lift = new Lift[countLifts];
    ApplicationsThread applicationsThread = new ApplicationsThread();

    public LiftManager() {
        applicationsThread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < countLifts; i++) {
            lift[i] = new Lift(i);
            lift[i].getListFloors().add(0);
        }

        while (true) {
            for (int j = 0; j < 2; j++) {
                if (applicationsThread.getApplications().size() > 0) {
                    lift[j].getListFloors().add(applicationsThread.getApplications().get(0).getInitialFloor());
                    lift[j].getListFloors().add(applicationsThread.getApplications().get(0).getFinalFloor());
                    System.out.println("lift " + (j + 1) + " get " + applicationsThread.getApplications().get(0).getInitialFloor() + "  " + applicationsThread.getApplications().get(0).getFinalFloor());
                    applicationsThread.getApplications().remove(0);
                }
                AllMove();
            }
        }
    }
}
