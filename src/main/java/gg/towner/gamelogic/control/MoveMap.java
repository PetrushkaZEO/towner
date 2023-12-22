package gg.towner.gamelogic.control;

import gg.towner.gamelogic.Player;
import gg.towner.graphics.GameWindow;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;

public class MoveMap {

        private Camera camera;
        public void setCamera(Scene scene){
            camera = new PerspectiveCamera();
            scene.setCamera(camera);
            camera.setScaleX(1);
            camera.setScaleY(1);
            camera.setTranslateX(0);
            camera.setTranslateY(0);
            GameWindow.buildMenu.invisibleMenu();
        }

        public void mapScale(Scene scene){
            scene.setOnScroll(event -> {
                if(event.getDeltaY() < 1 && camera.getScaleX() < 3) {
                    camera.setScaleX(camera.getScaleX() + 0.12);
                    camera.setTranslateX(camera.getTranslateX() - 55);
                    camera.setScaleY(camera.getScaleY() + 0.12);
                    camera.setTranslateY(camera.getTranslateY() - 55);
                }
                if(event.getDeltaY() > 1 && camera.getScaleX() > 0.69){
                    camera.setScaleX(camera.getScaleX() - 0.12);
                    camera.setTranslateX(camera.getTranslateX() + 55);
                    camera.setScaleY(camera.getScaleY() - 0.12);
                    camera.setTranslateY(camera.getTranslateY() + 55);
                }
                if(camera.getScaleX() < 0.7){
                    if(!Player.isTownCreate){
                        GameWindow.buildMenu.visibleFoundMenu();
                        GameWindow.buildMenu.setFoundButtonPositions(camera.getTranslateX() + 350, camera.getTranslateY() + 350);
                        return;
                    }
                    GameWindow.buildMenu.visibleMenu();
                    GameWindow.buildMenu.setButtonPositions(camera.getTranslateX() + 30, camera.getTranslateY() + 360);

                } else {
                    if(!Player.isTownCreate){
                        GameWindow.buildMenu.invisibleFoundMenu();
                        return;
                    }
                    GameWindow.buildMenu.invisibleMenu();
                }
            });


        }
        private double pointX;
        private double pointY;
        public void moveMap(Scene scene){
            scene.setOnMousePressed(event -> {
                pointX = event.getX();
                pointY = event.getY();
            });
            scene.setOnMouseDragged(event -> {
                if(camera.getTranslateX() > 35000 && (pointX - event.getX()) > 0){
                    return;
                }
                if(camera.getTranslateX() < -35500 && (pointX - event.getX()) < 0){
                    return;
                }
                if(camera.getTranslateY() > 35000 && (pointY - event.getY()) > 0){
                    return;
                }
                if(camera.getTranslateY() < -35000 && (pointY - event.getY()) < 0){
                    return;
                }
                camera.setTranslateX(camera.getTranslateX() + ((pointX - event.getX()) / 1.65));
                camera.setTranslateY(camera.getTranslateY() + ((pointY - event.getY()) / 1.65));
                if(Player.isTownCreate) {
                    GameWindow.buildMenu.moveButtons((pointX - event.getX()) / 1.65, (pointY - event.getY()) / 1.65);
                } else {
                    GameWindow.buildMenu.moveFoundButtonPos((pointX - event.getX()) / 1.65, (pointY - event.getY()) / 1.65);
                }
                pointX = event.getX();
                pointY = event.getY();

            });
        }
}
