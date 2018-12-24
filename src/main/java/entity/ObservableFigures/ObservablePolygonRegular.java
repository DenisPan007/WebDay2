package entity.ObservableFigures;

import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import servise.util.observer.Observable;
import servise.util.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class ObservablePolygonRegular extends PolygonRegular implements Observable {
    private List<Observer> listOfObservers = new ArrayList<>();

    public ObservablePolygonRegular(Point3d middlePoint, int edgeNumber, double edgeSize) {
        super(middlePoint, edgeNumber, edgeSize);
    }

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
    @Override
    public void setEdgeNumber(int edgeNumber) {
        super.setEdgeNumber(edgeNumber);
        notifyObservers();
    }
    @Override
    public void setEdgeSize(double edgeSize) {
        super.setEdgeSize(edgeSize);
        notifyObservers();
    }
    @Override
    public void setMiddlePoint(Point3d middlePoint) {
        super.setMiddlePoint(middlePoint);
        notifyObservers();
    }
}
