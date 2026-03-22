package Observer;

import Observer.ConcreteObservers.*;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        System.out.println("Current temperature: " + station.getTemperature());

        station.addObserver(new Phone());
        station.addObserver(new Desktop());

        Thread stationThread = new Thread(station);
        stationThread.start();

        try {
            Thread.sleep(10000);
            station.stop();
            stationThread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println("Weather station stopped.");
    }
}
