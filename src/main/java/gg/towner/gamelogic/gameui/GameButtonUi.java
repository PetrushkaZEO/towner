package gg.towner.gamelogic.gameui;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class GameButtonUi {

    private final Image defaultTexture;
    private final Image mouseEnterTexture;
    private final Image mouseClickedTexture;
    private final ImageView buttonView;

    public GameButtonUi(int x, int y, int width, int height, String defTexture, String mouseEnterTexture, String mouseClickedTexture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        defaultTexture = new Image(defTexture);
        this.mouseEnterTexture = new Image(mouseEnterTexture);
        this.mouseClickedTexture = new Image(mouseClickedTexture);
        buttonView = new ImageView();
        buttonView.setTranslateX(x);
        buttonView.setTranslateY(y);
        buttonView.setFitWidth(getWidth());
        buttonView.setFitHeight(getHeight());
        buttonView.setImage(defaultTexture);
    }
    public void show(Group group){
        group.getChildren().add(buttonView);
    }

    public void hide(Group group){
        group.getChildren().remove(buttonView);
    }

    public void setDefaultTexture(){
        buttonView.setImage(defaultTexture);
    }
    public void setMouseEnterTexture(){
        buttonView.setImage(mouseEnterTexture);
    }
    public void setMouseClickedTexture(){
        buttonView.setImage(mouseClickedTexture);
    }
    private int x;
    private int y;
    private int width;
    private int height;

    public ImageView getButtonView() {
        return buttonView;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
