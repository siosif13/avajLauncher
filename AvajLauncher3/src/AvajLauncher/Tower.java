package AvajLauncher;

import java.util.ArrayList;

import AvajLauncher.Airships.Flyable;

abstract class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){

        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {

        observers.remove(flyable);
    }

    protected void conditionsChanged() {

        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}


