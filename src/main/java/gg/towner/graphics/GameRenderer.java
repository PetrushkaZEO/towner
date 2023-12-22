package gg.towner.graphics;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameRenderer extends Canvas {


    public GameRenderer(){
        super(4000, 4000);
    }
    public void drawTrees(){
        GraphicsContext gc = this.getGraphicsContext2D();
        Image mage = new Image("structures/tree3.png");
        gc.drawImage(mage, 100, 100, 1000, 1000);
    }

    public void addToGroup(Group group){
        group.getChildren().add(this);
        this.toFront();
        this.toFront();
    }

}

