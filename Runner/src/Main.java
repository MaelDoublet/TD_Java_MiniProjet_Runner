import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("A la recherche de réseaux");
        Image desert;
        desert = new Image("im/desert.png");


        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene theScene = new GameScene(pane,desert);



    /*primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
        primaryStage.setHeight(newValue.doubleValue() / 2);
    });

    primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
        primaryStage.setWidth(newValue.doubleValue() * 2);
    });*/
        /*AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long time){
            theScene.render();
        }
        };*/
        primaryStage.setScene(theScene);


        //Fixer les dimensions de la fenetre
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(439);
        primaryStage.setMaxWidth(700);
        primaryStage.setMaxHeight(439);

        primaryStage.show();
    }
}