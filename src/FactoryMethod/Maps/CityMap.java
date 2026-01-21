package FactoryMethod.Maps;

import FactoryMethod.Tiles.*;
import java.util.*;

public class CityMap extends Map {
    private final char[] tileTypes = {'B', 'F', 'R'};

    @Override
    protected Tile createTile() {
        return this.getRandomTileType(this.tileTypes);
    }
}
