import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heart extends StaticThing{
    private State state;
    private Image image;
    public enum State {
        full,half,empty
    }
    public Heart(double sizeX, double sizeY) {
        super(sizeX, sizeY, new ImageView(new Image("im/Heart.png")));
        this.image=new Image("im/Heart.png");
        //this.getImage().setViewport(Rectangle2D());
    }

}
