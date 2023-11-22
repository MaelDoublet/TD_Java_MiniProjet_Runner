import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("Hello world");

    /*Image spriteSheet = new Image("C:\\Users\\LENOVO\\TD_Java_MiniProjet_Runner\\Runner\\im\\heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);*/

    Group root = new Group();
    Pane pane = new Pane(root);
    //Scene theScene = new Scene(pane, 600, 400,true);
    Camera camera= new Camera(300,100);
    GameScene theScene = new GameScene(pane,camera);
    primaryStage.setScene(theScene);


    primaryStage.show();
    }
}