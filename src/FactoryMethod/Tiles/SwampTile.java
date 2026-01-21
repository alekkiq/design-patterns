package FactoryMethod.Tiles;

public class SwampTile extends Tile {
    public SwampTile() {
        super('S', "swamp");
    }

    @Override
    public void action() {return;}
}
