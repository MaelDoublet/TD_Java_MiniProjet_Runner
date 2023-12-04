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
        primaryStage.setTitle("Hello world");
        Image desert;
        desert = new Image("im/desert.png");

        //Image spriteSheet = new Image("C:\\Users\\LENOVO\\TD_Java_MiniProjet_Runner\\Runner\\im\\heros.png");
        // ImageView sprite = new ImageView(spriteSheet);
        // sprite.setViewport(new Rectangle2D(20,0,65,100));
        // sprite.setX(200);
        // sprite.setY(300);
        //ImageView backgroundLeft = new ImageView(desert);
        //ImageView backgroundRight = new ImageView(desert);
        //Image desert = new Image(getClass().getClassLoader().getResource("Runner/im/desert.png").toString());
        //Image desert = new Image(getClass().getClassLoader().getResourceAsStream("im/desert.png"));

        //ImageView background = new ImageView(desert);

        /*URL imageUrl = getClass().getClassLoader().getResource("im/desert.png");
        if (imageUrl != null) {
            Image desert = new Image(imageUrl.toString());
        } else {
            System.out.println("L'image n'a pas été trouvée.");
        }*/

        Group root = new Group();
        Pane pane = new Pane(root);
        //Pane pane =new Pane(backgroundLeft,backgroundRight);
    //Scene theScene = new Scene(pane, 600, 400,true);
    //Camera camera= new Camera(300,100);
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



    /*primaryStage.setMinWidth(600);
    primaryStage.setMinHeight(300);
    primaryStage.setMaxWidth(870);
    primaryStage.setMaxHeight(435);*/

       /* primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(438);
        primaryStage.setMaxWidth(700);
        primaryStage.setMaxHeight(439);*/

    primaryStage.show();
    }
}