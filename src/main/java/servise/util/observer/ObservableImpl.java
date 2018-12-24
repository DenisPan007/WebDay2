package servise.util.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableImpl implements Observable {
    private List<Observer> listOfObservers = new ArrayList<>();
    public void addObserver(Observer observer){
        if(observer != null) {
            listOfObservers.add(observer);
        }
    }
    public void removeObserver(Observer observer){
        if(observer != null) {
            listOfObservers.remove(observer);
        }

    }
    public void notifyObservers(){
        for (Observer observer:listOfObservers) {
            observer.update(this);
        }

    }
}
