package entity;

import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import entity.Figures.Pyramid;
import org.junit.Test;
import static org.junit.Assert.*;
public class PyramidTest {

    @Test
    public void equals() {
        Point3d p1 = new Point3d();
        Point3d p2 = new Point3d(1,2,3);
        Point3d p3 = new Point3d(2,3,4);
        Point3d p4 = new Point3d(2,6,4);
        Point3d p5 = new Point3d(4,2,1);
        PolygonRegular po1 = new PolygonRegular(p1, 3, 1);
        PolygonRegular po2 = new PolygonRegular(p2, 1, 1);
        Pyramid py1 = new Pyramid(p1, po1);
        Pyramid py2 = new Pyramid(p1, po2);
        Pyramid py3 = new Pyramid(p2, po2);
        Pyramid py4 = new Pyramid(p1, po1);
        assertNotEquals(py1,py2);
        assertEquals(py1,py4);
        assertNotEquals(py2,py3);
    }
}