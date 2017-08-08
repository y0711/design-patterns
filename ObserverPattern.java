import java.util.ArrayList;

/**
 * Created by yabinh on 07/08/2017.
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Observer adam = new Player("Adam");
        Observer bob = new Player("Bob");
        Observer david = new Player("David");

        ControlCenter center = new AllyControlCenter();
        center.add(adam);
        center.add(bob);
        center.add(david);

        bob.beAttacked(center);
    }
}

abstract class ControlCenter {
    protected ArrayList<Observer> observers = new ArrayList<Observer>();

    void add(Observer observer) {
        System.out.println(observer.getName() + " joins the team.");
        observers.add(observer);
    }
    void remove(Observer observer) {
        observers.remove(observer);
    }
    abstract void notify(String name);
}

class AllyControlCenter extends ControlCenter {
    @Override
    void notify(String name) {
        for(Observer o : observers) {
            if (!o.getName().equals(name)) {
                o.help();
            }
        }
    }
}

interface Observer {
    String getName();
    void help();
    void beAttacked(ControlCenter center);
}

class Player implements Observer {
    private String name;
    Player(String name) {this.name = name;}
    @Override
    public String getName() {return name;}
    @Override
    public void help() {System.out.println("Don't worry. " + getName() + " is coming to help.");}
    @Override
    public void beAttacked(ControlCenter center) {
        System.out.println(getName() + " is being attacked. Help!");
        center.notify(getName());
    }
}
