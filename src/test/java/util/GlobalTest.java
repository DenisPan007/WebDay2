package util;

import entities.Figure;
import entities.Pyramid;
import org.junit.Test;
import util.validators.ValidatorFigure;
import util.validators.ValidatorPyramidData;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GlobalTest {
    @Test
    public void globalTest() throws Exception{
        String filePath = "Data.txt";
        List<String> listFile =  ReaderFile.readFile(filePath);
        ValidatorFigure validator = new ValidatorPyramidData();
        List<Figure> actualList = ListFiguresBuilder.buildListFigures(listFile,validator);
        Pyramid p1 = new Pyramid(0,0,27,
                0,0,0,4,6);
        Pyramid p2 = new Pyramid(0,2,27,
                0,0,3,4,6);
        List<Pyramid> expectedList = new ArrayList<Pyramid>();
        expectedList.add(p1);
        expectedList.add(p2);
        assertEquals(expectedList,actualList);
    }
}
