package JavaClasswork.Lesson1.Lesson7;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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

import java.util.concurrent.CopyOnWriteArrayList;

public class ProcessDrawing extends Application {
    LiftManager threadLiftManager=new LiftManager();
    CopyOnWriteArrayList<Passenger> applicationsLiftOne;

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
        Rectangle[] rectangles=new Rectangle[3];

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
        up(rectangles[0], 0, 9);
        up(rectangles[1], 0, 5);
        up(rectangles[2], 0, 3);
        //up(rectangles[1], threadLiftManager.lifts[1].getCurrentFloor(), 9);
       // up(rectangles[2], threadLiftManager.lifts[2].getCurrentFloor(), 7);
        primaryStage.show();
        /*down(rectangles[0], threadLiftManager.lifts[0].getCurrentFloor(), 1);
        primaryStage.setScene(scene);
        primaryStage.show();*/
       /* KeyValue yValue=new KeyValue(rectangles[0].yProperty(),180);

        KeyFrame keyFrame=new KeyFrame(Duration.seconds(7*3),yValue);

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();

        //root.getChildren().add(rectangles[0]);*/


    }

    void up(Rectangle rectangle,int currentFloor, int finalFloor) throws InterruptedException {
        int difference=Math.abs(currentFloor-finalFloor);
        int moveFloor=810-finalFloor*90;
        KeyValue yValue=new KeyValue(rectangle.yProperty(),moveFloor);

        KeyFrame keyFrame=new KeyFrame(Duration.seconds(difference*3),yValue);

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();

    }

    void down(Rectangle rectangle,int currentFloor, int finalFloor){
        int difference=Math.abs(currentFloor-finalFloor);
        int moveFloor=900-finalFloor*90;
        KeyValue yValue=new KeyValue(rectangle.yProperty(),moveFloor);

        KeyFrame keyFrame=new KeyFrame(Duration.seconds(difference*3),yValue);

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
    }

}
