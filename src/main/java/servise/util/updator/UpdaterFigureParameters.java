package servise.util.updator;

import dataAccess.DaoParameters;
import dataAccess.DaoParametersImpl;
import dataBases.DataBaseOfFigureParameters;
import servise.util.observer.Observer;

public abstract class UpdaterFigureParameters implements Observer {
    private DataBaseOfFigureParameters dataBase = DataBaseOfFigureParameters.getInstance();
    protected DaoParameters dao= new DaoParametersImpl(dataBase);
}
