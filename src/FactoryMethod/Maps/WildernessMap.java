package FactoryMethod.Maps;

public class WildernessMap extends Map {
    private final char[] tileTypes = {'S', 'W', 'F'};

    @Override
    protected char createTile() {
        return getRandomTileType(this.tileTypes);
    }
}
