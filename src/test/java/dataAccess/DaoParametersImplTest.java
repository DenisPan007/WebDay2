package dataAccess;

import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import entity.ParametersWarehouse.WarehouseOfParameters;
import entity.ParametersWarehouse.WarehouseOfParameters2D;
import org.junit.Test;
import dataBases.DataBaseOfFigureParameters;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DaoParametersImplTest {

    @Test
    public void add() {
        DataBaseOfFigureParameters dataBaseActual = DataBaseOfFigureParameters.getInstance();
        DaoParametersImpl dao = new DaoParametersImpl(dataBaseActual);
        dataBaseActual.get().clear();
        PolygonRegular p1 = new PolygonRegular();
        WarehouseOfParameters w1 = new WarehouseOfParameters2D(1, 2);
        dao.add(p1.getId(),w1);
        Map<Integer, WarehouseOfParameters> mapExpected = new HashMap<>();
        mapExpected.put(p1.getId(),w1);
        assertEquals(dataBaseActual.get(),mapExpected);
    }

    @Test
    public void remove() {DataBaseOfFigureParameters dataBaseActual = DataBaseOfFigureParameters.getInstance();
        DaoParametersImpl dao = new DaoParametersImpl(dataBaseActual);
        PolygonRegular p1 = new PolygonRegular();
        PolygonRegular p2 = new PolygonRegular(new Point3d(),2,4);
        WarehouseOfParameters w1 = new WarehouseOfParameters2D(1, 2);
        WarehouseOfParameters w2 = new WarehouseOfParameters2D(1, 4);
        dataBaseActual.get().put(p1.getId(),w1);
        dataBaseActual.get().put(p2.getId(),w2);
        Map<Integer, WarehouseOfParameters> mapExpected = new HashMap<>();
        mapExpected.put(p1.getId(),w1);
        dao.remove(p2.getId());
        assertEquals(dataBaseActual.get(),mapExpected);
    }
}