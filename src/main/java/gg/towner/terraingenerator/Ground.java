package gg.towner.terraingenerator;

import gg.towner.gamesource.GameObject;
import javafx.scene.image.ImageView;

public class Ground {
    private final GroundType type;
    private final ImageView groundView;
    private double x;
    private double y;
    private  ImageView objectView;
    public Ground(double x, double y, ImageView objectView, GroundType type) {
        groundView = objectView;
        this.x = x;
        this.y = y;
        this.type = type;
        groundView.setTranslateX(getX());
        groundView.setTranslateY(getY());
        groundView.setFitWidth(8);
        groundView.setFitHeight(8);
    }

    public ImageView getGroundView() {
        return groundView;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ImageView getObjectView() {
        return objectView;
    }

    public void setObjectView(ImageView objectView) {
        this.objectView = objectView;
    }

    public GroundType getType() {
        return type;
    }
}
