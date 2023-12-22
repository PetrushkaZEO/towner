package gg.towner.gamelogic.buildsystem;

import gg.towner.gamelogic.townsystem.Town;
import gg.towner.terraingenerator.Map;

public class BuildManager {

    public void spawnStructure(int x, int y, StructureType type, Town town){
        Structure structure = new Structure(type, x, y);
        town.getTownStructures().add(structure);
    }

    public void destroyStructure(Town town, Structure structure){
        town.getTownStructures().remove(structure);
    }
}
