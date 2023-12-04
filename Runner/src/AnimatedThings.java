import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThings {
    private ImageView spriteSheet;
    private double x;
    private double y;
    private Attitude attitude;
    private final int scrollSpeed;
    public enum Attitude {
        chill, course, sauter, tomber
    }
    //private int attitude;
    private int deltaT;//temps entre deux animations

    public AnimatedThings(Image character, double x, double y,int scrollSpeed) {
        this.spriteSheet = new ImageView(character);
        spriteSheet.setViewport(new Rectangle2D(20,0,65,100));
        spriteSheet.setX(x);
        spriteSheet.setY(y);
        this.x=x;
        this.y=y;
        this.attitude= Attitude.chill;
        this.scrollSpeed=scrollSpeed;
    }

    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
}
