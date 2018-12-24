package servise.util.validator;

import exeption.NotValidArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorPyramidDataTest {

    @Test
    public void isValid() throws NotValidArgumentException {
        ValidatorFigure validator = new ValidatorPyramidData();
        String str1 = "0,0d,27,0,0,0,4,6";
        String str2 = "-0.5,35,27,0,0,80,4,6";
        String str3 = "-0.5,35,5,0,0,5,4,6";
        assertFalse(validator.isValid(str1));
        assertTrue(validator.isValid(str2));
        assertFalse(validator.isValid(str3));

    }
}