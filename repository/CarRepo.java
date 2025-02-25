package Test.repository;

import java.util.List;

import Test.models.Car;

public interface CarRepo {
    public int save(Car car);

    public boolean delete(Car car);

    public Car findById(int id);

    public boolean update(Car car, Car updatedCar);

    public List<Car> findAll();

}
