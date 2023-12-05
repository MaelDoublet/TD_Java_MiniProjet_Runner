import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThings {
    private ImageView spriteSheet;
    private double x;
    private double y;
    protected Attitude attitude;
    private final int scrollSpeed;
    private boolean gun;
    public enum Attitude {
        run, jump, fall
    }
    //private int attitude;
    private int deltaT;//temps entre deux animations

    public AnimatedThings(Image character, double x, double y,int scrollSpeed) {
        this.spriteSheet = new ImageView(character);

        spriteSheet.setX(x);
        spriteSheet.setY(y);
        this.x=x;
        this.y=y;
        this.attitude= Attitude.run;
        this.scrollSpeed=scrollSpeed;

        this.gun=false;
    }

    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
    public void getFrame(int row, int column) {
        if(gun){
            row=row+300;
        }
        spriteSheet.setViewport(new Rectangle2D( 5+column * 84, row * 157, 78, 105));

    }


}
