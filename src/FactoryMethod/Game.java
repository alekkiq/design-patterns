package FactoryMethod;

import FactoryMethod.Maps.*;

public class Game {
    public Map createMap(int width, int height) {
        return new CityMap(width, height);
        // return new WildernessMap(width, height);
    }

    public static void main(String[] args) {
        Game game = new Game();
        Map map = game.createMap(5, 5);
        map.display();
    }
}
