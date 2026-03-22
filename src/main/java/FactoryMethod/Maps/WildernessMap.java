package FactoryMethod.Maps;

import FactoryMethod.Tiles.*;
import java.util.*;

public class WildernessMap extends Map {
    private static Random rng = new Random();

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int randomTile = rng.nextInt(3);

        return switch (randomTile) {
            case 0 -> new SwampTile();
            case 1 -> new ForestTile();
            default -> new WaterTile();
        };
    }
}
