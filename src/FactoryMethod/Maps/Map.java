package FactoryMethod.Maps;

import java.util.Random;

public abstract class Map {
    protected abstract char createTile();
    
    private Random tileRng = new Random();

    protected char getRandomTileType(char[] tileTypes) {
        int random = this.tileRng.nextInt(tileTypes.length);
        return tileTypes[random];
    }

    public void display() {
        // TODO
    }
}
