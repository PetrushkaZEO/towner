package gg.towner.gamesource;

import gg.towner.graphics.GameRenderer;
import javafx.scene.Node;
import javafx.scene.image.ImageView;


public class GameObject {
    private float x;
    private float y;
    private float width;
    private float height;
    private final ImageView objectView;
    private String tag;

    public GameObject(float x, float y, ImageView objectView, String tag, float width, float height) {
        this.x = x;
        this.y = y;
        this.objectView = objectView;
        this.tag = tag;
        this.width = width;
        this.height = height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ImageView getObjectView() {
        return objectView;
    }

    public String getTag() {
        return tag;
    }
}
