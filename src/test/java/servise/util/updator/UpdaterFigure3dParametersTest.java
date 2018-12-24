package servise.util.updator;

import entity.Figures.Point3d;
import entity.Figures.Pyramid;
import entity.ObservableFigures.ObservablePyramid;
import entity.ParametersWarehouse.WarehouseOfParameters;
import entity.ParametersWarehouse.WarehouseOfParameters3D;
import org.junit.Test;
import dataBases.DataBaseOfFigureParameters;
import servise.action.CounterParameters3d;
import servise.action.CounterParametersPyramid;
import servise.util.observer.Observable;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UpdaterFigure3dParametersTest {

    @Test
    public void update() {
        DataBaseOfFigureParameters dataBaseActual = DataBaseOfFigureParameters.getInstance();
        Map<Integer, WarehouseOfParameters> expectedMap = new HashMap<>();
        dataBaseActual.get().clear();
        CounterParameters3d counter = new CounterParametersPyramid();
        UpdaterFigureParameters updater = new UpdaterFigure3dParameters(counter);
        ObservablePyramid p = new ObservablePyramid(new Point3d(),new Point3d(),4,8);
        p.addObserver(updater);
        p.setTopPoint(new Point3d(1,2,3));
        p.setTopPoint(new Point3d(0,0,3));
        double perimeter = counter.perimeter(p);
        double sqr = counter.sqr(p);
        double volume = counter.volume(p);
        WarehouseOfParameters warehouse = new WarehouseOfParameters3D(perimeter,sqr,volume);
        expectedMap.put(p.getId(),warehouse);
        assertEquals(expectedMap,dataBaseActual.get());
    }
}