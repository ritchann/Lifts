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
    TranslateTransition tt=new TranslateTransition();
    SequentialTransition[] st=new SequentialTransition[2];
    Rectangle[] rectangles=new Rectangle[2];

    public ProcessDrawing() throws InterruptedException {
        threadLiftManager.start();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Line[] lines = new Line[9];
        int y = 90;
        for (int i = 0; i < 9; i++) {
            lines[i] = new Line(0, y, 1200, y);
            y += 90;
            lines[i].setStroke(Color.CADETBLUE);
            root.getChildren().add(lines[i]);
        }

        int x = 350;
        for (int i = 0; i < 2; i++) {
            rectangles[i] = new Rectangle(x, 810, 65, 90);
            rectangles[i].setStroke(Color.BLACK);
            switch (i) {
                case 0:
                    rectangles[0].setFill(Color.GOLD);
                    break;
                case 1:
                    rectangles[1].setFill(Color.TOMATO);
                    break;
            }
            root.getChildren().add(rectangles[i]);
            x += 500;
        }

        Text[] texts = new Text[10];
        y = 880;
        for (int i = 0; i < 10; i++) {
            texts[i] = new Text(10, y, Integer.toString(i) + " floor");
            y -= 90;
            texts[i].setFont(Font.font(20));
            root.getChildren().add(texts[i]);
        }

        for (int i = 0; i < 2; i++) {
            st[i] = new SequentialTransition(rectangles[i]);
        }

        primaryStage.setTitle("Lifts");
        Scene scene = new Scene(root, 1200, 900);

        primaryStage.setScene(scene);
        primaryStage.show();
/*
        move(rectangles[0],0,5,0);
        move(rectangles[0],5,1,0);
        move(rectangles[1],0,8,1);
        move(rectangles[2],0,3,2);
*/
  /*      int count=0;
        while (count<5) {
            if (threadLiftManager.lifts[0].getMoveApp().size() != 0) {
                move(rectangles[0], threadLiftManager.lifts[0].getMoveApp().get(0).getCurrentFloor(), threadLiftManager.lifts[0].getMoveApp().get(0).getFinalFloor(), 0);
                threadLiftManager.lifts[0].getMoveApp().remove(0);
                //st[0]=new SequentialTransition(rectangles[0]);
                //st[0].pause();
                count++;
            }
        }
*/
        /*st[0].playFromStart();*/
/*
        int count=0;
        while (count<10){
            for (int i = 0; i <3 ; i++) {
                if(threadLiftManager.lifts[i].getMoveApp().size()>0){
                    count++;
                    move(rectangles[i],threadLiftManager.lifts[i].getMoveApp().get(0).getCurrentFloor(),threadLiftManager.lifts[i].getMoveApp().get(0).getFinalFloor(),i);
                    threadLiftManager.lifts[i].getMoveApp().remove(0);
                }
            }
        }
*/
       /* move(rectangles[1], 0, 5, 1);
        st[1].playFromStart();
        move(rectangles[0], 0, 8, 0);
        st[0].playFromStart();
        move(rectangles[0], 8, 5, 0);
        st[0].playFromStart();
        move(rectangles[0], 5, 9, 0);
        st[0].playFromStart();
        move(rectangles[0], 9, 0, 0);
        st[0].playFromStart();
        move(rectangles[0], 0, 3, 0);
        st[0].playFromStart();*/
    }

    void move(Rectangle rectangle,int currentFloor,int finalFloor,int numberLift) throws InterruptedException {
        int time=Math.abs(currentFloor-finalFloor)*1;
        tt=new TranslateTransition(Duration.seconds(time),rectangle);
        tt.setToY(finalFloor*(-90));
        st[numberLift].getChildren().add(tt);
        st[numberLift].playFromStart();
    }

    /*void move(Rectangle rectangle,int currentFloor,int finalFloor, int numberLift){
        int time=Math.abs(currentFloor-finalFloor);
        int finalY=810-finalFloor*90;
        KeyValue keyValue=new KeyValue(rectangle.yProperty(),finalY);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(time),keyValue);
        Timeline timeline = new Timeline(keyFrame);
        //st[numberLift]= new SequentialTransition(timeline);
        st[numberLift].getChildren().add(timeline);
        st[numberLift].playFromStart();
    }*/
}
