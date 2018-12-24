package servise.util;

import entity.Figures.Figure;
import entity.Figures.Pyramid;
import org.junit.Test;
import servise.util.fileRead.ReaderFile;
import servise.util.validator.ValidatorFigure;
import servise.util.validator.ValidatorPyramidData;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCreateFiguresFromFile {
    @Test
    public void globalTest() throws Exception{
        String filePath = "src/test/Data.txt";
        List<String> listFile =  ReaderFile.readFile(filePath);
        ValidatorFigure validator = new ValidatorPyramidData();
        ListFiguresBuilder builder = new ListFiguresBuilder();
        List<Figure> actualList = builder.buildListFigures(listFile,validator);
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
