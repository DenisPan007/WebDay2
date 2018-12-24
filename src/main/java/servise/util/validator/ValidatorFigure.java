package servise.util.validator;

import exeption.NotValidArgumentException;
import servise.util.creator.CreatorFigure;

public interface ValidatorFigure {
    boolean isValid(String str) throws NotValidArgumentException;
    CreatorFigure getCreator();
}
