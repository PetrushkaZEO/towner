package gg.towner.terraingenerator;

import gg.towner.gamelogic.townsystem.Town;
import gg.towner.graphics.GameWindow;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map extends Canvas{
    private String name;
    private List<Town> towns = new ArrayList<>();
    private final List<double[][]> rectangles = new ArrayList<>();
    private Town chosenTown;
    public Map(String name){
        super(4000,4000);
        this.name = name;
    }
    public void generateTerrain(Group group){
        GraphicsContext context = this.getGraphicsContext2D();
        double z;
        Random random = new Random();
        Random random1 = new Random();
        Rectangle rect = new Rectangle(-2200, -1200, 8200, 6200);
        rect.setFill(new Color(0.29, 0.48, 1, 1));
        group.getChildren().add(rect);
        Image grass1 = new Image("grass1.png");
        Image grass2 = new Image("grass2.png");
        Image grass3 = new Image("grass3.png");
        Image tree1 = new Image("tree1.png");
        Image tree2 = new Image("tree2.png");
        Image stone1 = new Image("structures/stone1.png");
        Image stone2 = new Image("structures/stone2.png");
        Image mount1 = new Image("mount1.png");
        Image mount2 = new Image("mount2.png");
        Image mount3 = new Image("mount3.png");
        Image hGrass1 = new Image("hGrass1.png");
        Image hGrass2 = new Image("hGrass2.png");
        Image snow1 = new Image("snow1.png");
        Image snow2 = new Image("snow2.png");
        Image tree3 = new Image("structures/tree3.png");
        Canvas layer2 = new Canvas(4000, 4000);
        GraphicsContext gc = layer2.getGraphicsContext2D();
        Image sand = new Image("sand.png");
        Image water = new Image("smallwater.png");
        Noise test = new Noise();
        double[][] map = test.generateNoise();
        rectangles.add(map);
        double zMin = 100;
        double zMax = 0;
        double zNorm;
        for (double[] doubles : map) {
            for (int j = 0; j < map.length; j++) {
                z = doubles[j];
                if(z < zMin){
                    zMin = z;
                }
                if(z > zMax){
                    zMax = z;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                z = map[j][i];
                zNorm = (z - zMin) / (zMax - zMin);
                if(zNorm >= 0.92){
                    int a = random.nextInt(2);
                    if(a == 0) {
                        context.drawImage(snow1, j * 8, i * 8, 8, 8);
                    }
                    if(a == 1) {
                        context.drawImage(snow2, j * 8, i * 8, 8, 8);
                    }
                }
                if(zNorm >= 0.84 && zNorm < 0.92){
                    int a = random.nextInt(3);
                    if(a == 0) {
                        context.drawImage(mount1, j * 8, i * 8, 8, 8);
                    }
                    if(a == 1) {
                        context.drawImage(mount2, j * 8, i * 8, 8, 8);
                    }
                    if(a == 2) {
                        context.drawImage(mount3, j * 8, i * 8, 8, 8);
                    }
                }
                if(zNorm >= 0.78 && zNorm < 0.84){
                    int a = random.nextInt(2);
                    if(a == 0) {
                        context.drawImage(hGrass1, j * 8, i * 8, 8, 8);
                    }
                    if(a == 1) {
                        context.drawImage(hGrass2, j * 8, i * 8, 8, 8);
                    }
                } 
                if(zNorm >= 0.46 && zNorm < 0.78){
                    int a = random.nextInt(3);
                    if(a == 0) {
                        context.drawImage(grass1, j * 8, i * 8, 8, 8);
                    }
                    if(a == 1) {
                        context.drawImage(grass2, j * 8, i * 8, 8, 8);
                    }
                    if(a == 2) {
                        context.drawImage(grass3, j * 8, i * 8, 8, 8);
                    }
                }
                if(zNorm >= 0.44 && zNorm <= 0.46){
                    context.drawImage(sand, j * 8, i * 8, 8, 8);
                }
                if(zNorm > 0.32 && zNorm < 0.44) {
                    context.drawImage(water, j * 8, i * 8, 8, 8);
                }
                if(zNorm <= 0.4) {
                    Rectangle rectangle = new Rectangle(j * 8, i * 8, 8, 8);
                    group.getChildren().add(rectangle);
                    rectangle.setFill(new Color(0.29, 0.48, 1, 1));
                }


                if(zNorm >= 0.49 && zNorm < 0.77){
                    int a = random.nextInt(2200);
                    if(a < 5){
                        gc.drawImage(tree1, j * 8 - 50, i * 8 - 100, 76, 68);
                    }
                    if(a < 10){
                        gc.drawImage(tree2, j * 8 - 50, i * 8 - 100, 76, 68);
                    }
                    if(a < 15){
                        gc.drawImage(tree3, j * 8 - 50, i * 8 - 70, 76, 68);
                    }
                }

                if(zNorm >= 0.49 && zNorm < 0.82){
                    int a = random1.nextInt(12500);
                    if(a == 411){
                        gc.drawImage(stone1, j * 8 - 30, i * 8 - 60, 26, 22);
                    }
                    if(a == 29){
                        gc.drawImage(stone2, j * 8 - 40, i * 8 - 60, 32, 17);
                    }
                }

            }
        }
        GameWindow.root.getChildren().add(this);
        GameWindow.root.getChildren().add(layer2);
        layer2.toFront();
        layer2.toFront();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Town> getStructures() {
        return towns;
    }

    public List<double[][]> getDouble() {
        return rectangles;
    }
}
