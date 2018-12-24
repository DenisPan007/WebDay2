package dataBases;

import entity.Figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOfFigures {
    private static DataBaseOfFigures instance;
    private List<Figure> figureList;
    private DataBaseOfFigures() {
        this.figureList = new ArrayList<>();
    }
    public static DataBaseOfFigures getInstance(){
        if(instance == null){
            instance = new DataBaseOfFigures();
        }
        return instance;
    }

    public List<Figure> get() {
        return figureList;
    }
}
