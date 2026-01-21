package FactoryMethod.Maps;

import FactoryMethod.Tiles.*;
import java.util.Random;

public abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;

    protected Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        this.generate();
    }

    protected abstract Tile createTile();

    private void generate() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = this.createTile();
            }
        }
    }

    public void display() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(this.tiles[y][x].getCharacter());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
