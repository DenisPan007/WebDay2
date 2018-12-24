package servise.util.updator;

import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import entity.ObservableFigures.ObservablePolygonRegular;
import entity.ParametersWarehouse.WarehouseOfParameters;
import entity.ParametersWarehouse.WarehouseOfParameters2D;
import org.junit.Test;
import dataBases.DataBaseOfFigureParameters;
import servise.action.CounterParameters2d;
import servise.action.CounterParametersPolygonRegular;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import static org.junit.Assert.*;

public class UpdaterFigure2dParametersTest {

    @Test
    public void update() {
        DataBaseOfFigureParameters dataBase = DataBaseOfFigureParameters.getInstance();
        Map<Integer, WarehouseOfParameters> expectedMap = new HashMap<>();
        dataBase.get().clear();
        CounterParameters2d counter = new CounterParametersPolygonRegular();
        UpdaterFigureParameters updater = new UpdaterFigure2dParameters(counter);
        ObservablePolygonRegular p = new ObservablePolygonRegular(new Point3d(),3,3);
        p.addObserver(updater);
        p.setEdgeNumber(3);
        p.setEdgeNumber(4);
        WarehouseOfParameters warehouse = new WarehouseOfParameters2D(12,9);
        expectedMap.put(p.getId(),warehouse);
        assertEquals(expectedMap,dataBase.get());
    }
}