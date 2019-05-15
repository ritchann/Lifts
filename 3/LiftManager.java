package JavaClasswork.Lesson1.Lesson7;

public class LiftManager extends Thread {
    Lift[] lift = new Lift[2];
    ApplicationsThread applicationsThread = new ApplicationsThread();

    public LiftManager() {
        applicationsThread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            lift[i] = new Lift();
            lift[i].start();
        }
        lift[0].setDirection(Direction.up);
        lift[0].setCurrentFloor(0);
        lift[1].setDirection(Direction.down);
        lift[1].setCurrentFloor(9);
        while (true) {
            for (int i = 0; i < 2; i++) {

                if(lift[i].getDirection().equals(Direction.up)){
                    for (int j = 0; j < applicationsThread.getApplicationsUp().size(); j++) {
                        if(lift[i].getCurrentFloor()<=applicationsThread.getApplicationsUp().get(j).getInitialFloor() && (lift[i].getWeightInLift()+applicationsThread.getApplicationsUp().get(j).getWeight())<500){
                            Passenger tempPass=applicationsThread.getApplicationsUp().get(j);
                            System.out.println("Lift "+(i+1)+" get application on "+tempPass.getInitialFloor()+" to "+tempPass.getFinalFloor());
                            applicationsThread.getApplicationsUp().remove(j);
                            lift[i].getListFloors().add(tempPass.getInitialFloor());
                            lift[i].getListFloors().add(tempPass.getFinalFloor());
                            lift[i].setWeightInLift(lift[i].getWeightInLift()+applicationsThread.getApplicationsUp().get(j).getWeight());
                            lift[i].getWeightPassengers().set(tempPass.)
                        }
                    }
                }


                if(lift[i].getDirection().equals(Direction.down)){
                    for (int j = 0; j < applicationsThread.getApplicationsDown().size(); j++) {
                        if(lift[i].getCurrentFloor()>=applicationsThread.getApplicationsDown().get(j).getInitialFloor()){
                            Passenger tempPass=applicationsThread.getApplicationsDown().get(j);
                            System.out.println("Lift "+(i+1)+" get application on "+tempPass.getInitialFloor()+" to "+tempPass.getFinalFloor());
                            applicationsThread.getApplicationsDown().remove(j);
                            lift[i].getListFloors().add(tempPass.getInitialFloor());
                            lift[i].getListFloors().add(tempPass.getFinalFloor());
                        }
                    }
                }
            }
        }
    }
}
/*
    Passenger searchPassenger(Lift lift){
        int length=0;
        Passenger passenger;
        while(true){
            if(lift.getCurrentFloor()+length<10) {
                if()
                if ((passenger=searchFloor(lift.getCurrentFloor() + length)) != null) {
                    return passenger;
                }
            }

            if(lift.getCurrentFloor()-length>=0) {
                if ((passenger=searchFloor(lift.getCurrentFloor() - length)) != null) {
                    return passenger;
                }
            }
            length++;
        }
    }*/
/*
    Passenger searchFloor(int floor){
        for (int i = 0; i <applicationsThread.getApplications().size() ; i++) {
            if(applicationsThread.getApplications().get(i).getInitialFloor()==floor){
                Passenger passenger=applicationsThread.getApplications().get(i);

                applicationsThread.getApplications().remove(passenger);

                if(applicationsThread.getApplicationsDown().contains(passenger))
                    applicationsThread.getApplicationsDown().remove(passenger);

                if(applicationsThread.getApplicationsUp().contains(passenger))
                    applicationsThread.getApplicationsDown().remove(passenger);

                return passenger;
            }
        }
        return null;
    }*/

