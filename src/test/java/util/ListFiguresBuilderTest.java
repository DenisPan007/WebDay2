package util;

import entities.Figure;
import entities.Pyramid;
import exeptions.NotValidArgumentException;
import org.junit.Test;
import util.validators.ValidatorFigure;
import util.validators.ValidatorPyramidData;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListFiguresBuilderTest {

    @Test
    public void buildListFigures() throws NotValidArgumentException {
        String str1 = "0,0,27;0,0,0;4,6";
        String str2 = "0,2,27;0,0,3;4,6";
        String str3 = "0,2a,27;0,0,3;4,6";// not valid string
        String str4 = "0,2,6;0,0,6;4,6";// not valid string
        List<String> listFile = new ArrayList<String>();
        listFile.add(str1);
        listFile.add(str2);
        listFile.add(str3);
        listFile.add(str4);
        ValidatorFigure v1 = new ValidatorPyramidData();
        List<Pyramid> expectedList = new ArrayList<Pyramid>();
        Pyramid p1 = new Pyramid(0,0,27,
                0,0,0,4,6);
        Pyramid p2 = new Pyramid(0,2,27,
                0,0,3,4,6);
        expectedList.add(p1);
        expectedList.add(p2);
        List<Figure> actualList = ListFiguresBuilder.buildListFigures(listFile,v1);
        assertEquals(expectedList,actualList);
    }
}