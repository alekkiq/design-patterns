package FactoryMethod.Tiles;

public abstract class Tile {
    private char character;
    private String description;

    public Tile(char character, String description) {
        this.character = character;
        this.description = description;
    }

    protected abstract void action();

    public char getCharacter() {
        return this.character;
    }

    public String getDescription() {
        return this.description;
    }
}
