package dataAccess;

import dataAccess.specification.SpecificationFigure;
import entity.Figures.Figure;

import java.util.List;

public interface RepoFigure {
    void add(Figure figure);
    void remove(Figure figure);
    void update(Figure figureToUpdate,Figure figure);
    List<Figure> query(SpecificationFigure specification);
}
