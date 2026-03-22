package FactoryMethod.Tiles;

public class ForestTile extends Tile {
    @Override
    public char getCharacter() { return 'F'; }

    @Override
    public String getType() { return "Forest"; }

    @Override
    public String getDescription() {
        return "Scary forest that may hide dangers within.";
    }

    public void action() {
        // not used
    }
}
