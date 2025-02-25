package Test.repository;

import java.util.List;

import Test.models.Fuel;

public interface FuelRepo {

    public List<Fuel> getAllFuelType();

    public Boolean addFuelType(Fuel fuel);
}
