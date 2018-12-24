package entity.Figures;


import servise.util.observer.ObservableImpl;

public abstract class Figure extends ObservableImpl {
    private static int idCounter = 0;
    {idCounter++;}
    private int id = idCounter;
    public int getId() {
        return id;
    }

}
