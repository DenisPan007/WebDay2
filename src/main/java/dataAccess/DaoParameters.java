package dataAccess;

import entity.ParametersWarehouse.WarehouseOfParameters;


public interface DaoParameters {
    void add(Integer hashKey, WarehouseOfParameters listParameters);
    void remove(Integer hashKey);
    void update(Integer hashKey, WarehouseOfParameters listParameters);
}
