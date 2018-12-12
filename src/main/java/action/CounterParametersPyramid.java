package action;

import entities.Figure;
import entities.Point3d;
import entities.PolygonRegular;
import entities.Pyramid;
import exeptions.NotValidArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CounterParametersPyramid implements CounterParameters3d {
    private static final Logger logger = LogManager.getLogger(CounterParametersPyramid.class);
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

    public double sqr(Figure figure) throws NotValidArgumentException {
        if (figure == null){
            logger.error("null as argument has been detected");
            throw new NotValidArgumentException("null as argument has been detected");
        }
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        double sqrBasis = sqrBasis(pyramid);
        double sqrSide = basis.getEdgeNumber()* getApothem(pyramid)*basis.getEdgeSize()*0.5;
        return sqrBasis + sqrSide;

    }
    public double volume(Figure figure) throws NotValidArgumentException {
        if (figure == null){
            logger.error("null as argument has been detected");
            throw new NotValidArgumentException("null as argument has been detected");
        }
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        double sqrBasis = sqrBasis(pyramid);
        return sqrBasis * getHeight(pyramid) * 1/3;
    }


    public double ratio(Figure figure, double z) throws NotValidArgumentException {
        if (figure == null){
            logger.error("null as argument has been detected");
            throw new NotValidArgumentException("null as argument has been detected");
        }
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
    public  boolean isBasisOnAxis(Figure figure) throws NotValidArgumentException {
        if (figure == null){
            logger.error("null as argument has been detected");
            throw new NotValidArgumentException("null as argument has been detected");
        }
        Pyramid pyramid = (Pyramid) figure;
        PolygonRegular basis = pyramid.getBasis();
        Point3d middlePoint = basis.getMiddle();
        return (middlePoint.getZ() == 0);
    }
    public  boolean isFigure(Object obj){
        return obj instanceof Pyramid;
    }
}
