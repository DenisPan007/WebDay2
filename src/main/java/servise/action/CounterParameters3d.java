package servise.action;

import entity.Figures.Figure;
import exeption.NotValidArgumentException;

public interface CounterParameters3d extends CounterParameters2d{
    double volume(Figure figure);

    /**
     * Method returns ratio of the volume of the figure
     *      * which is obtained from the cross by coordinate plane (XY)
     *      * to volume of the original figure
     * @param figure
     * @return
     */
    double ratio(Figure figure, double z);
    boolean isBasisOnAxis(Figure figure);
    boolean isFigure(Object obj);

}

