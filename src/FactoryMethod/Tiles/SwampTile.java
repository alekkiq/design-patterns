package FactoryMethod.Tiles;

public class SwampTile extends Tile {
    @Override
    public char getCharacter() { return 'S'; }

    @Override
    public String getType() { return "Swamp"; }

    @Override
    public String getDescription() {
        return "Muddy swamp that slows movement and may contain an ogre.";
    }

    public void action() {
        // not used
    }
}
