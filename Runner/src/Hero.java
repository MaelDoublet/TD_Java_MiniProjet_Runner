import javafx.scene.image.Image;


public class Hero extends AnimatedThings{
    public static double scrollSpeed;
    public static int hp;

    public Hero(Image character, double x, double y) {
        super(character, x, y,10);
        this.scrollSpeed = 10;
        this.hp = 8;
    }
}
