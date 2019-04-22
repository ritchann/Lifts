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
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rectangle=new Rectangle(0,0,50,50);
        //KeyValue xValue=new KeyValue(rectangle.xProperty(),100);
        KeyValue yValue=new KeyValue(rectangle.yProperty(),1000);

        KeyFrame keyFrame=new KeyFrame(Duration.seconds(2),yValue);

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();

        Group root=new Group();
        root.getChildren().add(rectangle);
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();
    }
}
