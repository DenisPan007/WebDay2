package util.validators;

import exeptions.NotValidArgumentException;
import util.creators.CreatorFigure;

public interface ValidatorFigure {
    boolean isValid(String str) throws NotValidArgumentException;
    CreatorFigure getCreator();
}
