import com.sun.prism.image.ViewPort;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
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

    protected StaticThing left_Background;
    protected StaticThing right_Background;
    private Image background;
    private Image lifePoint;

    private static int backgroundSpeed= 10;
    private Pane pane;

    public GameScene(Pane pane,Image background) {
        super(pane,600,300);
        this.pane=pane;
        this.camera = new Camera(300,100);

        //this.backgroundSpeed=10;

        this.background= background;
        this.left_Background= new StaticThing(800,400,new ImageView(background));
        this.right_Background= new StaticThing(800,400,new ImageView(background));
        left_Background.getImage().setX(0);
        right_Background.getImage().setX(800);
        left_Background.getImage().setY(0);
        right_Background.getImage().setY(0);
        /*left_Background.getImage().setStyle("-fx-background-color: lightblue;");
        right_Background.getImage().setStyle("-fx-background-color: lightgreen;");*/
        pane.getChildren().addAll(left_Background.getImage(),right_Background.getImage());
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;
            private double deltaT= 1.0 / 60.0;
            @Override
            public void handle(long time){
                if(time-lastUpdate>deltaT){
                    render();
                    update();
                    lastUpdate=time;
                }

            }
        };
        timer.start();



        //pane.getChildren().addAll();
        Hero hero = new Hero(new Image("im/heros.png"),200,250);
        pane.getChildren().addAll(hero.getSpriteSheet());
        pane.requestFocus();



    }




    public void render(){
        // Mettre à jour la position des images en fonction du défilement
        left_Background.getImage().setTranslateX(left_Background.getImage().getTranslateX() - backgroundSpeed);
        right_Background.getImage().setTranslateX(right_Background.getImage().getTranslateX() - backgroundSpeed);

        // Vérifier si une image est entièrement sortie de l'écran, puis la replacer à droite de l'autre
        if (left_Background.getImage().getTranslateX() <= -800/*-getWidth()*/) {
            left_Background.getImage().setTranslateX(0/*left_Background.getImage().getTranslateX() + getWidth()*/);
        }
        if (right_Background.getImage().getTranslateX() <=-800/*-getWidth()*/) {
            right_Background.getImage().setTranslateX(0/*left_Background.getImage().getTranslateX() + getWidth()*/);
        }
    }

    public void update(){
        //pane.getChildren().clear();
        //pane.getChildren().addAll(left_Background.getImage(),right_Background.getImage());
    }
}
