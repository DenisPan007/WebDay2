package dataAccess.specification;

import entity.Figures.Figure;
import entity.Figures.Point3d;
import entity.Figures.PolygonRegular;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetByNameTest {

    @Test
    public void specified() {
        Figure p = new Point3d();
        GetByName spec = new GetByName(Point3d.class);
        assertTrue(spec.specified(p));
    }
    @Test
    public void notSpecified() {
        Figure p = new Point3d();
        GetByName spec = new GetByName(PolygonRegular.class);
        assertFalse(spec.specified(p));
    }
}