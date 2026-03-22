package Observer.ConcreteObservers;

import Observer.Observer;

public class Phone implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone display: Temperature updated to " + temperature + "C");
    }
}
