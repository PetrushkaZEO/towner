package gg.towner.gamelogic;

import gg.towner.gamelogic.control.MoveMap;
import gg.towner.gamelogic.gameui.GameButtonUi;
import gg.towner.graphics.GameWindow;
import gg.towner.terraingenerator.Map;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class GameMenu {
    private GameButtonUi newWorldButton;
    private GameButtonUi loadWorldButton;
    private GameButtonUi exitButton;
    public void createMenu(Group group){
        createButtons(group);
        registerButtonEvents(group);

    }

    private void createButtons(Group group){
        newWorldButton = new GameButtonUi(50, 170, 300, 130, "buttons/buttonDef.png", "buttons/buttonEnter.png", "buttons/buttonClick.png");
        newWorldButton.show(group);
        Text text = new Text("Создать Мир");
        text.setTranslateX(160);
        text.setTranslateY(230);
        text.setScaleX(3.6);
        text.setScaleY(3.6);
        group.getChildren().add(text);
        text.setFill(Color.WHITE);
        text.setMouseTransparent(true);
        text.setFont(Font.font("Retro Land Mayhem", 9));
        loadWorldButton = new GameButtonUi(50, 320, 300, 130, "buttons/buttonDef.png", "buttons/buttonEnter.png", "buttons/buttonClick.png");
        loadWorldButton.show(group);
        Text text1 = new Text("Загрузить мир");
        text1.setTranslateX(160);
        text1.setTranslateY(380);
        text1.setScaleX(3.6);
        text1.setScaleY(3.6);
        group.getChildren().add(text1);
        text1.setFill(Color.WHITE);
        text1.setMouseTransparent(true);
        text1.setFont(Font.font("Retro Land Mayhem", 9));
        exitButton = new GameButtonUi(50, 470, 300, 130, "buttons/buttonDef.png", "buttons/buttonEnter.png", "buttons/buttonClick.png");
        exitButton.show(group);
        Text text2 = new Text("Выйти");
        text2.setTranslateX(180);
        text2.setTranslateY(530);
        text2.setScaleX(3.6);
        text2.setScaleY(3.6);
        group.getChildren().add(text2);
        text2.setFill(Color.WHITE);
        text2.setMouseTransparent(true);
        text2.setFont(Font.font("Retro Land Mayhem", 12));
    }

    private void registerButtonEvents(Group group){
        newWorldButton.getButtonView().setOnMouseEntered(event -> {
            newWorldButton.setMouseEnterTexture();
        });
        newWorldButton.getButtonView().setOnMouseExited(event -> {
            newWorldButton.setDefaultTexture();
        });
        newWorldButton.getButtonView().setOnMouseClicked(event -> {
            newWorldButton.setMouseClickedTexture();
            new Timer() {
            }.schedule(new TimerTask() {
                @Override
                public void run() {
                    newWorldButton.setMouseEnterTexture();
                }
            }, 165);
            newWorldButton.hide(group);
            loadWorldButton.hide(group);
            exitButton.hide(group);
           /* Map map = new Map("world");
            map.testGen(group);
            GameWindow.chosedMap = map;
            GameWindow.isGame = true;
            MoveMap moveMap = new MoveMap();
            moveMap.setCamera(GameWindow.scene);
            moveMap.mapScale(GameWindow.scene);
            moveMap.moveMap(GameWindow.scene);
            GameWindow.buildMenu.hideMenu(group);
            GameWindow.buildMenu.invisibleMenu();
            GameWindow.buildMenu.hideFoundMenu(group);
            GameWindow.buildMenu.invisibleFoundMenu(); */
            Map map = new Map("map1");
            map.generateTerrain(group);
            GameWindow.isGame = true;
            MoveMap moveMap = new MoveMap();
            moveMap.setCamera(GameWindow.scene);
            moveMap.mapScale(GameWindow.scene);
            moveMap.moveMap(GameWindow.scene);
            GameWindow.buildMenu.hideMenu(group);
            GameWindow.buildMenu.invisibleMenu();
            GameWindow.buildMenu.hideFoundMenu(group);
            GameWindow.buildMenu.invisibleFoundMenu();
        });
        newWorldButton.getButtonView().setOnMousePressed(event -> {
            newWorldButton.setMouseClickedTexture();
        });
        loadWorldButton.getButtonView().setOnMouseEntered(event -> {
            loadWorldButton.setMouseEnterTexture();
        });
        loadWorldButton.getButtonView().setOnMouseExited(event -> {
            loadWorldButton.setDefaultTexture();
        });
        loadWorldButton.getButtonView().setOnMouseClicked(event -> {
            loadWorldButton.setMouseClickedTexture();
            new Timer() {
            }.schedule(new TimerTask() {
                @Override
                public void run() {
                    loadWorldButton.setMouseEnterTexture();
                }
            }, 165);
        });
        loadWorldButton.getButtonView().setOnMousePressed(event -> {
            loadWorldButton.setMouseClickedTexture();
        });
        exitButton.getButtonView().setOnMouseEntered(event -> {
            exitButton.setMouseEnterTexture();
        });
        exitButton.getButtonView().setOnMouseExited(event -> {
            exitButton.setDefaultTexture();
        });
        exitButton.getButtonView().setOnMouseClicked(event -> {
            exitButton.setMouseClickedTexture();
            new Timer() {
            }.schedule(new TimerTask() {
                @Override
                public void run() {
                    exitButton.setMouseEnterTexture();
                }
            }, 165);
            GameWindow.stage.close();
        });
        exitButton.getButtonView().setOnMousePressed(event -> {
            exitButton.setMouseClickedTexture();
        });
    }
    public void showMenu(Group group){
        System.out.println(exitButton.getButtonView().getX() + "/" + exitButton.getX());
        exitButton.show(group);
    }

    public void hideMenu(Group group){
        exitButton.hide(group);
    }
}
