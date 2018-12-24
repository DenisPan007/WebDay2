package dataBases;

import entity.ParametersWarehouse.WarehouseOfParameters;

import java.util.HashMap;
import java.util.Map;

public class DataBaseOfFigureParameters {

    private static DataBaseOfFigureParameters instance;
    private DataBaseOfFigureParameters() {
        this.parametersMap = new HashMap<>();
    }
    public static DataBaseOfFigureParameters getInstance(){
        if(instance == null){
            instance = new DataBaseOfFigureParameters();
        }
        return instance;
    }

    private Map<Integer, WarehouseOfParameters> parametersMap;

    public Map<Integer, WarehouseOfParameters> get() {
        return parametersMap;
    }

}
