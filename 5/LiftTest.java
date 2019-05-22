package JavaClasswork.Lesson1.Lesson7;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class LiftTest extends Application {
    final int countLifts=2;
    static Rectangle[] rectangles=new Rectangle[2];
    static LiftManager threadLiftManager=new LiftManager();

    public static void main(String[] args) throws InterruptedException {
        threadLiftManager.start();
        Application.launch(args);
        AllMove();
        //Thread.sleep(5000);

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


        primaryStage.setTitle("Lifts");
        Scene scene = new Scene(root, 1200, 900);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void move(int currentFloor,int finalFloor,int numberLift) throws InterruptedException {
        SequentialTransition st=new SequentialTransition();
        int time= Math.abs(currentFloor - finalFloor);
        TranslateTransition tt=new TranslateTransition(Duration.seconds(time),rectangles[numberLift]);
        tt.setToY(finalFloor*(-90));
        st.getChildren().add(tt);
        st.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                threadLiftManager.lift[numberLift].setMove(true);
                threadLiftManager.lift[numberLift].setCurrentFloor(finalFloor);
            }
        });
        st.play();
    }

    public static void AllMove(){
            for (int j = 0; j <2; j++) {
                if (threadLiftManager.lift[j].getListFloors().size() > 1 && threadLiftManager.lift[j].getMove()) {
                    try {
                        threadLiftManager.lift[j].setMove(false);
                        move(threadLiftManager.lift[j].getListFloors().get(0), threadLiftManager.lift[j].getListFloors().get(1), j);
                        threadLiftManager.lift[j].getListFloors().remove(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
