package servise.action;

import entity.Figures.Figure;
import exeption.NotValidArgumentException;

public interface CounterParameters2d {
    double sqr(Figure figure) ;
    double perimeter(Figure figure) ;
}
