package dataAccess;

import dataAccess.specification.SpecificationFigure;
import entity.Figures.Figure;
import dataBases.DataBaseOfFigures;
import java.util.ArrayList;
import java.util.List;

public class RepoFigureImpl implements RepoFigure {
    DataBaseOfFigures dataBase;

    public RepoFigureImpl(DataBaseOfFigures dataBase) {
        this.dataBase = dataBase;
    }
    public void add(Figure figure){
        dataBase.get().add(figure);

    }
    public void remove(Figure figure){
        dataBase.get().remove(figure);
    }
    public void update(Figure figureToUpdate,Figure figure){
        int index = dataBase.get().indexOf(figureToUpdate);
        if (index != -1) {
            dataBase.get().remove(index);
            dataBase.get().add(index, figure);
        }
    }
    public List<Figure> query(SpecificationFigure specification){
        List<Figure> list = new ArrayList<>();
        for (Figure figure: dataBase.get()) {
            if (specification.specified(figure)){
                list.add(figure);
            }
        }
        return list;
    }
}