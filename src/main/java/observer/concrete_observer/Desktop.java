package observer.concrete_observer;

import observer.Observer;

public class Desktop implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Desktop display: Temperature updated to " + temperature + "C");
    }
}
