package JavaClasswork.Lesson1.Lesson7;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.concurrent.CopyOnWriteArrayList;

public class ProcessDrawing extends Application {
    LiftManager threadLiftManager=new LiftManager();
    CopyOnWriteArrayList<Passenger> applicationsLiftOne;
    SequentialTransition[] sequentialTransition=new SequentialTransition[3];
    Rectangle[] rectangles=new Rectangle[3];

    public ProcessDrawing(){
        threadLiftManager.start();
        applicationsLiftOne=threadLiftManager.lifts[0].getApplications();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root=new Group();
        Line[] lines=new Line[9];
        int y=90;
        for (int i = 0; i <9 ; i++) {
            lines[i]=new Line(0,y,1500,y);
            y+=90;
            lines[i].setStroke(Color.CADETBLUE);
            root.getChildren().add(lines[i]);
        }



        int x=200;
        for (int i = 0; i <3 ; i++) {
            rectangles[i]=new Rectangle(x,810,65,90);
            rectangles[i].setStroke(Color.BLACK);
            switch (i){
                case 0:
                    rectangles[0].setFill(Color.GOLD);
                    break;
                case 1:
                    rectangles[1].setFill(Color.TOMATO);
                    break;
                case 2:
                    rectangles[2].setFill(Color.ORCHID);
                    break;
            }
            root.getChildren().add(rectangles[i]);
            x+=450;
        }

        Text[] texts=new Text[10];
        y=880;
        for (int i = 0; i <10 ; i++) {
            texts[i]=new Text(10,y,Integer.toString(i)+" floor");
            y-=90;
            texts[i].setFont(Font.font(20));
            root.getChildren().add(texts[i]);
        }

        primaryStage.setTitle("Lifts");
        Scene scene= new Scene(root,1500,900);
        primaryStage.setScene(scene);
        for (int i = 0; i <3 ; i++) {
            sequentialTransition[i]=new SequentialTransition(rectangles[i]);
            sequentialTransition[i].setCycleCount(0);
        }

       /* up(0,threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(),0);
        up(threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(),threadLiftManager.lifts[0].getApplications().get(0).getFinalFloor(),0);

        threadLiftManager.lifts[0].getApplications().remove(0);

        down(9,threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(),0);
        //down(threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(),threadLiftManager.lifts[0].getApplications().get(0).getFinalFloor(),0);
*/
       int count=0;
        while(threadLiftManager.lifts[0].getApplications().size()>0 && count<5 ){
            count++;
            if (threadLiftManager.lifts[0].getCurrentFloor() < threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor()) {
                up(threadLiftManager.lifts[0].getCurrentFloor(), threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(), 0);
            } else {
                down(threadLiftManager.lifts[0].getCurrentFloor(), threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(), 0);
            }

            if (threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor() < threadLiftManager.lifts[0].getApplications().get(0).getFinalFloor()) {
                up(threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(), threadLiftManager.lifts[0].getApplications().get(0).getFinalFloor(), 0);
                // threadLiftManager.lifts[0].remove();
            } else {
                down(threadLiftManager.lifts[0].getApplications().get(0).getInitialFloor(), threadLiftManager.lifts[0].getApplications().get(0).getFinalFloor(), 0);
            }

        }
        //sequentialTransition[0].play();


        //sequentialTransition[0].play();
        //rectangles[0].setY(450);
        /*int appl=0;
        sequentialTransition[0].setCycleCount(0);
        while(appl<10000){
            for (int i = 0; i < 3; i++) {
                //up(0,9,2,0);
                for (int j = 0; j <threadLiftManager.lifts[i].getApplications().size() ; j++) {

                        //sequentialTransition[i].getChildren().removeAll();
                        // sequentialTransition[i]=new SequentialTransition(rectangles[i]);
                        //System.out.println( (i+1)+" APPLICATONS "+ threadLiftManager.lifts[i].getApplications().size()+" FROM "+threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor() +" TO " + threadLiftManager.lifts[i].getApplications().get(j).getFinalFloor() );
                        appl++;

                        int count=0;
                        if (threadLiftManager.lifts[i].getCurrentFloor() < threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor()) {
                            count++;
                            up(threadLiftManager.lifts[i].getCurrentFloor(), threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor(), i,count);
                        } else {
                            count++;
                            down(threadLiftManager.lifts[i].getCurrentFloor(), threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor(), i,count);
                        }

                        if (threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor() < threadLiftManager.lifts[i].getApplications().get(j).getFinalFloor()) {
                            count++;
                            up(threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor(), threadLiftManager.lifts[i].getApplications().get(j).getFinalFloor(), i,count);
                            // threadLiftManager.lifts[0].remove();
                        } else {
                            count++;
                            down(threadLiftManager.lifts[i].getApplications().get(j).getInitialFloor(), threadLiftManager.lifts[i].getApplications().get(j).getFinalFloor(), i,count);
                            //threadLiftManager.lifts[0].remove();
                        }
                        //threadLiftManager.lifts[i].move();
                        //SequentialTransition sequentialTransition = new SequentialTransition(rectangles[0]);

                        //threadLiftManager.lifts[0].setApplications();
                        //threadLiftManager.lifts[0].getApplications().remove(0);

                        //sequentialTransition.stop();
                }
            }
        }
        primaryStage.show();
        //sequentialTransition.play();
*/

       // primaryStage.show();
        //SequentialTransition sequentialTransition=new SequentialTransition();
        /*down(rectangles[0], threadLiftManager.lifts[0].getCurrentFloor(), 1);
        primaryStage.setScene(scene);
        */
        primaryStage.show();
       /* KeyValue yValue=new KeyValue(rectangles[0].yProperty(),180);

        KeyFrame keyFrame=new KeyFrame(Duration.seconds(7*3),yValue);

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
        SequentialTransition sequentialTransition=new SequentialTransition();
        //root.getChildren().add(rectangles[0]);*/


    }


    void up(int currentFloor, int finalFloor, int numberLift) throws InterruptedException {
        /*if(sequentialTransition[numberLift].getChildren().size()>1){
            sequentialTransition[numberLift]=new SequentialTransition(rectangles[numberLift]);
        }*/
        /*if(count==2)
        {
            threadLiftManager.lifts[numberLift].move();
        }*/
        int difference=Math.abs(currentFloor-finalFloor);
        int moveFloor=finalFloor*(-90);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(difference));
        translateTransition.setToY(moveFloor);
        sequentialTransition[numberLift].getChildren().add(translateTransition);
        sequentialTransition[numberLift].play();
    }

    void down(int currentFloor, int finalFloor, int numberLift) throws InterruptedException {
        /*if(sequentialTransition[numberLift].getChildren().size()>1){
            sequentialTransition[numberLift]=new SequentialTransition(rectangles[numberLift]);
        }*/
        /*if(count==2) {
            threadLiftManager.lifts[numberLift].move();
        }*/
        int difference=Math.abs(currentFloor-finalFloor);
        int moveFloor=finalFloor*(-90);
        System.out.println(moveFloor);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(difference));
        translateTransition.setToY(moveFloor);
        sequentialTransition[numberLift].getChildren().addAll(translateTransition);
        sequentialTransition[numberLift].play();
    }
}
