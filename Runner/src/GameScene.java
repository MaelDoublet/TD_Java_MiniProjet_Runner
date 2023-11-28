import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameScene extends Scene {
    private Camera camera;

    private StaticThing left_Background;
    private StaticThing right_Background;
    private Image background;

    public GameScene(Pane pane,Image background) {
        super(pane,600,300);
        this.camera = new Camera(300,100);

        this.background= background;
        this.left_Background= new StaticThing(800,400,new ImageView(background));
        this.right_Background= new StaticThing(800,400,new ImageView(background));
        left_Background.getImage().setX(0);
        right_Background.getImage().setX(800);
        left_Background.getImage().setY(0);
        right_Background.getImage().setY(0);

        pane.getChildren().addAll(left_Background.getImage(),right_Background.getImage());

    }


    public void render(){

    }

}
