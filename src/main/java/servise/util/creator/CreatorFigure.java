package servise.util.creator;

import entity.Figures.Figure;
import exeption.NotValidArgumentException;

public interface CreatorFigure {
    Figure create(String str) throws NotValidArgumentException;
}
