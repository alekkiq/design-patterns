package FactoryMethod.Tiles;

public class BuildingTile extends Tile {
    @Override
    public char getCharacter() { return 'B'; }

    @Override
    public String getType() { return "Building"; }

    @Override
    public String getDescription() {
        return "Building that could contain loot or perhaps enemies.";
    }

    public void action() {
        // not used
    }
}
