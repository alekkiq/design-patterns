package FactoryMethod.Tiles;

public class RoadTile extends Tile {
    @Override
    public char getCharacter() { return 'R'; }

    @Override
    public String getType() { return "Road"; }

    @Override
    public String getDescription() {
        return "Road tile that allows easy travel.";
    }

    public void action() {
        // not used
    }
}
