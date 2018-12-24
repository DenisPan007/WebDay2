package servise.action;

import dataBases.DataBaseOfFigures;
import entity.Figures.Figure;
import entity.Figures.Point3d;
import org.junit.Test;
import servise.util.comparator.CompareById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SortFiguresTest {

    @Test
    public void sort() {
        SortFigures sorter = new SortFigures();
        Comparator byId = new CompareById();
        Point3d p1 = new Point3d();
        Point3d p2 = new Point3d(1,1,1);
        Point3d p3 = new Point3d(2,2,2);
        List<Figure> list = Arrays.asList(p3,p1,p2);
        List<Figure> listExpected = Arrays.asList(p1,p2,p3);
        List<Figure> listActual = sorter.sort(list,byId);
        assertEquals(listExpected,listActual);
    }
}