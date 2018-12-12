package util.creators;

import entities.Figure;
import entities.Pyramid;
import exeptions.NotValidArgumentException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreatorPyramidTest {

    @Test
    public void create() throws NotValidArgumentException {
        String str = "0,0,27,0,0,0,4,6";
        CreatorFigure creator = new CreatorPyramid();
        Pyramid expectedPyr = new Pyramid(0,0,27,
                0,0,0,4,6);
        Figure actualPyr = creator.create(str);
        assertEquals(actualPyr,expectedPyr);
    }
}