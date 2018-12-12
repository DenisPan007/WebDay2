package action;

import entities.Figure;
import exeptions.NotValidArgumentException;

public interface CounterParameters3d {
    double sqr(Figure figure) throws NotValidArgumentException;
    double volume(Figure figure) throws NotValidArgumentException;

    /**
     * Method returns ratio of the volume of the figure
     *      * which is obtained from the cross by coordinate plane (XY)
     *      * to volume of the original figure
     * @param figure
     * @return
     */
    double ratio(Figure figure, double z) throws NotValidArgumentException;
    boolean isBasisOnAxis(Figure figure) throws NotValidArgumentException;
    boolean isFigure(Object obj);

}

