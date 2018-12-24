package servise.action;

import entity.Figures.Figure;
import entity.Figures.PolygonRegular;


public class CounterParametersPolygonRegular implements CounterParameters2d {

    public double perimeter(Figure figure) {
        PolygonRegular polygon = (PolygonRegular) figure;
        return polygon.getEdgeNumber() * polygon.getEdgeSize();
    }
    public double sqr(Figure figure) {
        PolygonRegular polygon = (PolygonRegular) figure;
        return GeometricCounter.sqrPolygonRegular(polygon);
    }
}
