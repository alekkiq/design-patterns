package FactoryMethod.Tiles;

public class WaterTile extends Tile {
    @Override
    public char getCharacter() { return 'W'; }

    @Override
    public String getType() { return "Water"; }

    @Override
    public String getDescription() {
        return "Water tile that slows movement.";
    }

    public void action() {
        // not used
    }
}
