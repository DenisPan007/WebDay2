package dataAccess.specification;

import entity.Figures.Figure;

public class GetById implements SpecificationFigure {
    private int idFrom;
    private int idTo;

    public GetById(int idFrom,int idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specified(Figure figure) {
        return (figure.getId() <= idTo&&figure.getId() >= idFrom);
    }
}
