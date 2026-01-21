package FactoryMethod.Tiles;

public class ForestTile extends Tile {
    public ForestTile() {
        super('F', "forest");
    }

    @Override
    public void action() {return;}
}
