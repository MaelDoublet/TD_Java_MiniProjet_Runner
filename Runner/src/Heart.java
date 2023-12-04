import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heart extends StaticThing{
    private State state;
    public enum State {
        full,half,empty
    }
    public Heart(double sizeX, double sizeY, ImageView image) {

        super(sizeX, sizeY, new ImageView(new Image("im/Heart.png")));
        //this.getImage().setViewport(Rectangle2D());
    }

}
