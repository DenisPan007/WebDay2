package servise.util.comparator;

import entity.Figures.Figure;

import java.util.Comparator;

public class CompareById implements Comparator<Figure> {
    public int compare(Figure f1, Figure f2){
        int id1 = f1.getId();
        int id2 = f2.getId();
        return Integer.compare(id1,id2);
    }
}
