package gg.towner.gamelogic.townsystem;

import gg.towner.gamelogic.buildsystem.Structure;

import java.util.ArrayList;
import java.util.List;

public class Town {

    private List<Structure> townStructures = new ArrayList<>();
    private final int centerX;
    private final int centerY;
    private final int name;
    private int wood = 0;
    private int stone = 0;

    public Town(int centerX, int centerY, int name) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.name = name;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public List<Structure> getTownStructures() {
        return townStructures;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getName() {
        return name;
    }
}
