import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameScene extends Scene {
    private Camera camera;

    public GameScene(Parent parent, Camera camera) {
        super(parent);
        this.camera = camera;
    }


}
