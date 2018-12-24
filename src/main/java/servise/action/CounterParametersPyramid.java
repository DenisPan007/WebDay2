package servise.action;

import entity.Figures.Figure;
import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import entity.Figures.Pyramid;

public class CounterParametersPyramid implements CounterParameters3d {
    private double sqrBasis(Pyramid pyramid){
        PolygonRegular basis = pyramid.getBasis();
        return GeometricCounter.sqrPolygonRegular(basis);
    }
    private double getHeight(Pyramid pyramid){
        Point3d topPoint = pyramid.getTopPoint();
        Point3d topProjection = new Point3d(topPoint.getX(),topPoint.getY(),0);
        return GeometricCounter.distance(topPoint,topProjection);
    }
    private double getApothem(Pyramid pyramid){
        PolygonRegular basis = pyramid.getBasis();
        double radius = GeometricCounter.getRadiusEnteredCircle(basis);
        return Math.hypot(getHeight(pyramid), radius);
    }
    public double perimeter(Figure figure) {
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        return basis.getEdgeNumber()*basis.getEdgeSize();
    }

    public double sqr(Figure figure)  {
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        double sqrBasis = sqrBasis(pyramid);
        double sqrSide = basis.getEdgeNumber()* getApothem(pyramid)*basis.getEdgeSize()*0.5;
        return sqrBasis + sqrSide;

    }
    public double volume(Figure figure) {
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        double sqrBasis = sqrBasis(pyramid);
        return sqrBasis * getHeight(pyramid) * 1/3;
    }


    public double ratio(Figure figure, double z) {
        Pyramid pyramid = (Pyramid) figure;
        Point3d topPoint = pyramid.getTopPoint();
        Point3d middlePoint = pyramid.getBasis().getMiddle();
        Point3d topProjection = new Point3d(topPoint.getX(),topPoint.getY(), z);
        double heightCross = 0;
        if (z < topPoint.getZ() && z > middlePoint.getZ()
                ||z > topPoint.getZ() && z < middlePoint.getZ() ) {
            heightCross = GeometricCounter.distance(topPoint, topProjection);
        }
        double heightOriginal = getHeight(pyramid);
        double ratio = heightCross/heightOriginal;
        return Math.pow(ratio,1.0/3);
    }
    public  boolean isBasisOnAxis(Figure figure){
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        Point3d middlePoint = basis.getMiddle();
        return (middlePoint.getZ() == 0);
    }
    public  boolean isFigure(Object obj){
        return obj instanceof Pyramid;
    }
}
