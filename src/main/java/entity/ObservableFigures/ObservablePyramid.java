package entity.ObservableFigures;

import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import entity.Figures.Pyramid;
import servise.util.observer.Observable;
import servise.util.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservablePyramid extends Pyramid implements Observable {
    private List<Observer> listOfObservers = new ArrayList<>();

    public ObservablePyramid(Point3d topPoint, Point3d middlePoint, int numberSize, double edgeSize) {
        super(topPoint, middlePoint, numberSize, edgeSize);
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
    public void notifyObservers() {
        for (Observer observer : listOfObservers) {
            observer.update(this);
        }
    }
    @Override
    public void setTopPoint(Point3d topPoint) {
        super.setTopPoint(topPoint);
        notifyObservers();
    }
    @Override
    public void setBasis(PolygonRegular basis) {
        super.setBasis(basis);
        notifyObservers();
    }
}
