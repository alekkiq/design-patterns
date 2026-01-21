package FactoryMethod.Tiles;

public class BuildingTile extends Tile {
    public BuildingTile() {
        super('B', "building");
    }

    @Override
    public void action() {return;}
}
