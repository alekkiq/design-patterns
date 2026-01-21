package Observer.ConcreteObservers;

import Observer.Observer;

public class Desktop implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Desktop display: Temperature updated to " + temperature + "C");
    }
}
