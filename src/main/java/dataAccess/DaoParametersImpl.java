package dataAccess;

import entity.ParametersWarehouse.WarehouseOfParameters;
import dataBases.DataBaseOfFigureParameters;


public class DaoParametersImpl implements DaoParameters {
    private DataBaseOfFigureParameters dataBase;

    public DaoParametersImpl(DataBaseOfFigureParameters dataBase) {
        this.dataBase = dataBase;
    }

    public void add(Integer hashKey, WarehouseOfParameters listParameters){
        dataBase.get().put(hashKey,listParameters);
    }
    public void remove(Integer hashKey){
        dataBase.get().remove(hashKey);
    }
    public void update(Integer hashKey, WarehouseOfParameters listParameters){
        dataBase.get().replace(hashKey,listParameters);
    }
}
