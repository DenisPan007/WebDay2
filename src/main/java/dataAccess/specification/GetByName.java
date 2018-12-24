package dataAccess.specification;

import entity.Figures.Figure;


public class GetByName implements  SpecificationFigure {
    Class nameOfClass;

    public GetByName(Class nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    public boolean specified(Figure figure) {
        return (this.nameOfClass == figure.getClass());
    }
}
