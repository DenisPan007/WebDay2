package dataAccess;

import dataAccess.specification.GetById;
import dataAccess.specification.SpecificationFigure;
import entity.Figures.Figure;
import entity.Figures.Point3d;
import org.junit.Test;
import dataBases.DataBaseOfFigures;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RepoFigureImplTest {

    @Test
    public void add() {
        DataBaseOfFigures dataBaseActual = DataBaseOfFigures.getInstance();
        RepoFigureImpl figRepo = new RepoFigureImpl(dataBaseActual);
        dataBaseActual.get().clear();
        List<Figure> listExpected = Arrays.asList(new Point3d());
        figRepo.add (new Point3d());
        assertEquals(listExpected,dataBaseActual.get());
    }

    @Test
    public void remove() {
        DataBaseOfFigures dataBaseActual = DataBaseOfFigures.getInstance();
        RepoFigureImpl figRepo = new RepoFigureImpl(dataBaseActual);
        List<Figure> listExpected = Arrays.asList(new Point3d(1,2,3));
        dataBaseActual.get().add(new Point3d());
        dataBaseActual.get().add(new Point3d(1,2,3));
        figRepo.remove (new Point3d());
        assertEquals(listExpected,dataBaseActual.get());
    }

    @Test
    public void update() {
        DataBaseOfFigures dataBaseActual = DataBaseOfFigures.getInstance();
        RepoFigureImpl figRepo = new RepoFigureImpl(dataBaseActual);
        dataBaseActual.get().clear();
        List<Figure> listExpected = Arrays.asList(new Point3d(1,2,5),new Point3d(1,2,3));
        dataBaseActual.get().add(new Point3d());
        dataBaseActual.get().add(new Point3d(1,2,3));
        figRepo.update (new Point3d(),new Point3d(1,2,5));
        assertEquals(listExpected,dataBaseActual.get());
    }

    @Test
    public void query() {
        DataBaseOfFigures dataBase = DataBaseOfFigures.getInstance();
        dataBase.get().clear();
        Point3d p1 = new Point3d();
        Point3d p2 = new Point3d(1,2,3);
        Point3d p3 = new Point3d(2,2,2);
        Point3d p4 = new Point3d(3,3,3);
        dataBase.get().add(p1);
        dataBase.get().add(p2);
        dataBase.get().add(p3);
        dataBase.get().add(p4);
        SpecificationFigure specById = new GetById(p3.getId(),p4.getId());
        List<Figure> listExpected = Arrays.asList(p3,p4);
        RepoFigureImpl repo = new RepoFigureImpl(dataBase);
        List<Figure> listActual = repo.query(specById);
        assertEquals(listExpected,listActual);
    }
}