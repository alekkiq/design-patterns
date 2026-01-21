package FactoryMethod.Tiles;

public class WaterTile extends Tile {
    public WaterTile() {
        super('W', "water");
    }

    @Override
    public void action() {return;}
}
