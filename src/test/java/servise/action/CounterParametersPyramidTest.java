package servise.action;

import entity.Figures.Point3d;
import entity.Figures.Pyramid;
import exeption.NotValidArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CounterParametersPyramidTest {

    @Test
    public void sqr() throws NotValidArgumentException {
        Pyramid pyramidTest = new Pyramid(0,0,4,0,0,0,
                4,6);
        CounterParameters3d counter = new CounterParametersPyramid();
        double expectedSqr = 96;
        double actualSqr = counter.sqr(pyramidTest);
        assertTrue(expectedSqr == actualSqr);
    }

    @Test
    public void volume() throws NotValidArgumentException {
        Pyramid pyramidTest = new Pyramid(0,0,4,0,0,0,
                4,6);
        CounterParameters3d counter = new CounterParametersPyramid();
        double epsilon = 0.000001;
        double expectedVolume = 48;
        double actualVolume = counter.volume(pyramidTest);
        double difference = Math.abs(expectedVolume - actualVolume);
        assertTrue(difference < epsilon);
    }

    @Test
    public void ratio() throws NotValidArgumentException {
        Pyramid pyramidtest = new Pyramid(0,0,27,0,0,0,
                4,6);
        CounterParameters3d counter = new CounterParametersPyramid();
        double epsilon = 0.000001;
        double expectedRatio = 1.0/3;
        double actualRatio = counter.ratio(pyramidtest,26);
        double difference = Math.abs(expectedRatio - actualRatio);
        assertTrue(difference < epsilon);
    }

    @Test
    public void isBasisOnAxis() throws NotValidArgumentException {
        Pyramid pyramidtest1 = new Pyramid(0,0,27,0,0,0,
                4,6);
        Pyramid pyramidtest2 = new Pyramid(0,0,27,0,0,-3,
                4,6);
        CounterParameters3d counter = new CounterParametersPyramid();
        assertTrue(counter.isBasisOnAxis(pyramidtest1));
        assertFalse(counter.isBasisOnAxis(pyramidtest2));
    }
    @Test
    public  void isFigure(){
        Object obj1 = new Pyramid();
        Object obj2 = new Point3d();
        CounterParameters3d counter = new CounterParametersPyramid();
        assertTrue(counter.isFigure(obj1));
        assertFalse(counter.isFigure(obj2));
    }
}