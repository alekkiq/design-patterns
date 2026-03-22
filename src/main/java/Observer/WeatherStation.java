package Observer;

import java.util.*;

public class WeatherStation implements Observable, Runnable {
    private float temperature;
    private final Random random = new Random();
    private final List<Observer> observers = new ArrayList<>();
    private volatile boolean running = true;

    private final static int MIN_TEMP = -50;
    private final static int MAX_TEMP = 50;

    public WeatherStation() {
        this.temperature = this.random.nextInt(MAX_TEMP - MIN_TEMP) + MIN_TEMP;
    }

    public float getTemperature() {
        return this.temperature;
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public synchronized void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public synchronized void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.temperature);
        }
    }

    private void measureTemperature() {
        // change temp by -5 to +5 degrees
        float change = this.random.nextInt(11) - 5;
        this.temperature += change;
        notifyObservers();
    }

    @Override
    public void run() {
        while (this.running) {
            measureTemperature();

            int randomDelayMs = (this.random.nextInt(5) + 1) * 1000;

            try {
                Thread.sleep(randomDelayMs);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                this.running = false;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
