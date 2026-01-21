package FactoryMethod;

import FactoryMethod.Maps.*;

public class Game {
    public Map createMap() {
        return new CityMap();
    }

    public static void main(String[] args) {

    }
}
