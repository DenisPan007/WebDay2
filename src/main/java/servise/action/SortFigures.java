package servise.action;

import entity.Figures.Figure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortFigures {
    public List<Figure> sort (List<Figure> list,Comparator<Figure> comparator){
        ArrayList<Figure> arrayList = new ArrayList<>(list);
        arrayList.sort(comparator);
        return arrayList;
    }
}
