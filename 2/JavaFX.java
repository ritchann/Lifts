package JavaClasswork.Lesson1.Lesson7;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Scanner;


public class JavaFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       /* Rectangle rectangle=new Rectangle(0,0,50,50);
        KeyValue yValue=new KeyValue(rectangle.yProperty(),1000);
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(5),yValue);
        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();

      Rectangle rectangle1=new Rectangle(100,100,10,10);
        //KeyValue xValue=new KeyValue(rectangle.xProperty(),100);
        KeyValue xValue=new KeyValue(rectangle1.xProperty(),0);
        KeyFrame keyFrame1=new KeyFrame(Duration.seconds(5),xValue);

        Timeline timeline1=new Timeline();
        timeline1.getKeyFrames().addAll(keyFrame1);
        timeline1.play();


        Group root=new Group();
        root.getChildren().add(rectangle);
        root.getChildren().add(rectangle1);
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();*/
       try {
           Pane root = new Pane();

           Rectangle rect = new Rectangle(10, 200, 50, 50);
           rect.setFill(Color.ORCHID);

           TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2));
           translateTransition.setFromX(50);
           translateTransition.setToX(350);
          // translateTransition.setCycleCount(2);
           //translateTransition.setAutoReverse(true);

           TranslateTransition tranT = new TranslateTransition(Duration.seconds(2));
          // tranT.setFromX(10);
           tranT.setToX(200);
           tranT.setCycleCount(2);
           tranT.setAutoReverse(true);

           SequentialTransition seqT = new SequentialTransition(rect,translateTransition);
           //seqT.getChildren().addAll(translateTransition,tranT);
           //seqT.setCycleCount(Timeline.INDEFINITE);

           seqT.play();

           Scene scene = new Scene(root, 600, 600 );
           root.getChildren().add(rect);

           primaryStage.setScene(scene);
           primaryStage.show();
       }
       catch (Exception e){
           e.printStackTrace();
       }

    }
}
