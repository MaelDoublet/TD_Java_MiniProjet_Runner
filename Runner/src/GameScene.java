import com.sun.prism.image.ViewPort;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameScene extends Scene {
    private Camera camera;
    final double vitesseSaut = 12.1;
    double vitesseY=0;
    protected StaticThing left_Background;
    protected StaticThing right_Background;
    private Image background;
    private Image lifePoint;
    boolean saut=false;


    private static int backgroundSpeed = 10;
    private Pane pane;

    public GameScene(Pane pane, Image background) {
        super(pane, 600, 300);
        this.pane = pane;
        this.camera = new Camera(300, 100);

        //this.backgroundSpeed=10;

        this.background = background;
        this.left_Background = new StaticThing(800, 400, new ImageView(background));
        this.right_Background = new StaticThing(800, 400, new ImageView(background));
        left_Background.getImage().setX(0);
        right_Background.getImage().setX(800);
        left_Background.getImage().setY(0);
        right_Background.getImage().setY(0);

        pane.getChildren().addAll(left_Background.getImage(), right_Background.getImage());

        Hero hero = new Hero(new Image("im/heros.png"), 200, 100);
        pane.getChildren().addAll(hero.getSpriteSheet());
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;
            private double deltaT = 1.0 / 60.0;
            private int frameTimer = 0;


            int i=0;
            @Override
            public void handle(long time) {
                if (time - lastUpdate > deltaT) {
                    frameTimer++;
                    if(frameTimer>5 ) {
                        i=update_hero(hero,i);
                        frameTimer=0;
                    }

                    System.out.println(vitesseY);

                    hero.getSpriteSheet().setY(250 - isZero(vitesseY)*(vitesseSaut-vitesseY)*(vitesseSaut +vitesseY));//On met isZero pour enlever l'offset de la position neutre

                    if(vitesseY>0){
                        hero.attitude= AnimatedThings.Attitude.jump;
                        vitesseY--;
                    } else if(vitesseY<0){
                        hero.attitude= AnimatedThings.Attitude.fall;
                        vitesseY--;
                        if(vitesseY<-10){
                            vitesseY=0;
                            //hero.getSpriteSheet().setY(250);
                        }
                    } else{
                        vitesseY=0;
                        hero.attitude= AnimatedThings.Attitude.run;
                        saut= false;
                    }

                    /*if(hero.gun){
                        hero.gun=false;
                    }*/

                    render();
                    lastUpdate = time;

                }


            }
        };
        timer.start();


        pane.requestFocus();

        pane.setOnKeyPressed(event-> {
            if(event.getCode() == KeyCode.SPACE){
                if(!saut){ //On ajoute ce if pour forcer l'attente entre les sauts
                    saut=true;
                    vitesseY=vitesseSaut;
                }
            }

            if(event.getCode() == KeyCode.SHIFT){
                //On implemente la possibilité de tirer (pour le moment tendre la main)
                hero.gun= !hero.gun;
            }
        });
    }


    public void render() {
        // Mettre à jour la position des images en fonction du défilement
        left_Background.getImage().setTranslateX(left_Background.getImage().getTranslateX() - backgroundSpeed);
        right_Background.getImage().setTranslateX(right_Background.getImage().getTranslateX() - backgroundSpeed);

        // Vérifier si une image est entièrement sortie de l'écran, puis la replacer à droite de l'autre
        if (left_Background.getImage().getTranslateX() <= -800/*-getWidth()*/) {
            left_Background.getImage().setTranslateX(0/*left_Background.getImage().getTranslateX() + getWidth()*/);
        }
        if (right_Background.getImage().getTranslateX() <= -800/*-getWidth()*/) {
            right_Background.getImage().setTranslateX(0/*left_Background.getImage().getTranslateX() + getWidth()*/);
        }
    }

    public int update_hero(Hero hero,int i) {
        switch (hero.attitude) {
            case run -> {
                hero.getFrame(0,i);
                i++;
                if(i>5) {
                    i=0;
                }
                }
            case jump -> {
                hero.getFrame(1,0);
            }
            case fall -> {
                hero.getFrame(1,1);
            }
        }
        return i;
    }

    public int isZero(double i){
        if(i==0){
            return 0;
        }
        else {
            return 1;
        }
    }
}
