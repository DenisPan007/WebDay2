package util.creators;

import entities.Figure;
import exeptions.NotValidArgumentException;

public interface CreatorFigure {
    Figure create(String str) throws NotValidArgumentException;
}
