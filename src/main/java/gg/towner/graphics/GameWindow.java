package gg.towner.graphics;

import gg.towner.gamelogic.BuildMenu;
import gg.towner.gamelogic.GameMenu;
import gg.towner.terraingenerator.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameWindow extends Application {
    public static Group root;
    public static HBox box = new HBox();
    public static Stage stage;
    public static Scene scene;
    public static GameMenu mainMenu;
    public static BuildMenu buildMenu;
    public static GraphicsContext gc;
    public static Map chosedMap;
    public static boolean isGame = false;
    public static Group uiGroup;
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        scene = new Scene(root, 4000, 4000);
        root.getStylesheets().add(getClass().getResource("/retrofont.css").toExternalForm());
        root.getChildren().add(box);
        mainMenu = new GameMenu();
        mainMenu.createMenu(root);
        buildMenu = new BuildMenu();
        buildMenu.createMenu(root);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(scene);
        primaryStage.show();
        stage = primaryStage;
    }

    public static void drawALL(int x, int y){
        gc.drawImage(new Image("grass1.png"), x * 8 + 380, y * 8 + 120, 8, 8);
    }
}
