package servise.util.updator;

import entity.Figures.Pyramid;
import entity.ParametersWarehouse.WarehouseOfParameters;
import entity.ParametersWarehouse.WarehouseOfParameters3D;
import servise.action.CounterParameters3d;

public class UpdaterFigure3dParameters extends UpdaterFigureParameters {
    private CounterParameters3d counter;

    public UpdaterFigure3dParameters(CounterParameters3d counter) {
        this.counter = counter;
    }

    public void update(Object obj){
        Pyramid p1 = (Pyramid)obj;
        double perimeter = counter.perimeter(p1);
        double sqr = counter.sqr(p1);
        double volume = counter.volume(p1);
        WarehouseOfParameters warehouse = new WarehouseOfParameters3D(perimeter,sqr,volume);
        dao.add(p1.getId(),warehouse);
    }
}