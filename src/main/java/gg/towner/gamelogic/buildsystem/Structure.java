package gg.towner.gamelogic.buildsystem;

public class Structure {
    private StructureType structureType;
    private int x;
    private int y;
    private int width;
    private int height;

    public Structure(StructureType structureType, int x, int y) {
        this.structureType = structureType;
        this.x = x;
        this.y = y;
       if(structureType == StructureType.HOUSE){
           this.width = 8;
           this.height = 12;
       }
        if(structureType == StructureType.TOWNHALL){
            this.width = 24;
            this.height = 16;
        }
    }

    public StructureType getStructureType() {
        return structureType;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

}
