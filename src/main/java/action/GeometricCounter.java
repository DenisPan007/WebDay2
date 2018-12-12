package action;

import entities.Point3d;
import entities.PolygonRegular;

class GeometricCounter {
    static double distance(Point3d p1, Point3d p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        double dz = p1.getZ() - p2.getZ();
        double sum = Math.pow(dx,2) + Math.pow(dy,2) + Math.pow(dz,2);
        return Math.sqrt(sum);
    }
    static double perimeter(Point3d... args){
        double perimetr = 0;
        for(int i = 0; i < args.length - 1; i++){
            perimetr += distance(args[i], args[i+1]);
        }
        return perimetr;
    }

    /**
     * Geron's formula for square of triangle
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    static double sqrTriangle(Point3d p1,Point3d p2,Point3d p3){
        double p = perimeter(p1,p2,p3)/2;
        double a = distance(p1,p2);
        double b = distance(p2,p3);
        double c = distance(p3,p1);
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    /**
     * Square formula: S = a^2 * n / (4tg(Pi/n))
     *      * where a is edge size
     *      * n is edge number
     * @param po1
     * @return
     */
    static double sqrPolygonRegular(PolygonRegular po1){
        double edgeSize = po1.getEdgeSize();
        double edgeNumber = po1.getEdgeNumber();
        return Math.pow(edgeSize,2)*edgeNumber / (4 * Math.tan(Math.PI/edgeNumber));
    }
    static  double getRadiusEnteredCircle(PolygonRegular po1){
        return po1.getEdgeSize()/(2 * Math.tan(Math.PI/po1.getEdgeNumber()));
    }

}
