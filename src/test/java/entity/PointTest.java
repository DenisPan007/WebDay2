package entity;

import static org.junit.Assert.*;

import entity.Figures.Point3d;
import org.junit.Test;
public class PointTest {

    @Test
    public void equals() {
        Point3d p1 = new Point3d();
        Point3d p2 = new Point3d(0,0,0);
        Point3d p3 = new Point3d(1,1,1);
        assertEquals(p1,p2);
        assertNotEquals(p1,p3);
        assertNotEquals(p2,p3);

    }
}