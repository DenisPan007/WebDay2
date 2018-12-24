package servise.util.updator;

import entity.Figures.PolygonRegular;
import entity.ParametersWarehouse.WarehouseOfParameters;
import entity.ParametersWarehouse.WarehouseOfParameters2D;
import servise.action.CounterParameters2d;

public class UpdaterFigure2dParameters extends UpdaterFigureParameters {
    private CounterParameters2d counter;

    public UpdaterFigure2dParameters(CounterParameters2d counter) {
        this.counter = counter;
    }

    public void update(Object obj) {
        PolygonRegular p1 = (PolygonRegular)obj;
        double perimeter = counter.perimeter(p1);
        double sqr = counter.sqr(p1);
        WarehouseOfParameters warehouse = new WarehouseOfParameters2D(perimeter,sqr);
        dao.add(p1.getId(),warehouse);
    }
}
