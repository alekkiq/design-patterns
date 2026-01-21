package FactoryMethod.Tiles;

public class RoadTile extends Tile {
    public RoadTile() {
        super('R', "road");
    }

    @Override
    public void action() {return;}
}
