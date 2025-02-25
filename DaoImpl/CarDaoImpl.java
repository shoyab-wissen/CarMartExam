package Test.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.rowset.JdbcRowSet;

import Test.models.Car;
import Test.models.CarMeta;
import Test.models.Company;
import Test.models.Fuel;
import Test.models.Type;
import Test.repository.CarRepo;
import Test.util.DatabaseHandler;

public class CarDaoImpl implements CarRepo {
    JdbcRowSet rowset = DatabaseHandler.getHandler();

    @Override
    public int save(Car car) {
        try {
            rowset.setCommand("select * from car");
            rowset.execute();
            rowset.moveToInsertRow();
            rowset.updateString("company_name", car.getCompany().getName());
            rowset.updateString("type_name", car.getType().getTypeName());
            rowset.updateInt("model", car.getModel());
            rowset.updateDouble("price", car.getPrice());
            rowset.updateInt("seater", car.getSeater());
            rowset.updateBoolean("sold", car.isSold());
            rowset.updateString("fuel_type", car.getFuel().getFuelType());
            rowset.insertRow();
            return rowset.getInt("carid");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean delete(Car car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Car findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Car car, Car updatedCar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<Car>();
        try {
            rowset.setCommand("select * from type");
            rowset.execute();
            rowset.beforeFirst();
            while (rowset.next()) {
                String company = rowset.getString("company_name");
                String type = rowset.getString("type_name");
                int model = rowset.getInt("model");
                double price = rowset.getDouble("price");
                int seater = rowset.getInt("seater");
                int carid = rowset.getInt("carid");
                boolean sold = rowset.getBoolean("sold");
                String fuelType = rowset.getString("fuel_type");

                Car car = new Car.CarBuilder()
                        .carId(carid)
                        .company(CarMeta.getCarMeta().getCompany().stream()
                                .filter((Company comp) -> comp.getName() == company)
                                .collect(Collectors.toList()).get(0))
                        .fuel(CarMeta.getCarMeta().getFuel().stream()
                                .filter((Fuel fuel) -> fuel.getFuelType() == fuelType)
                                .collect(Collectors.toList()).get(0))
                        .type(CarMeta.getCarMeta().getType().stream()
                                .filter((Type types) -> types
                                        .getTypeName() == type)
                                .collect(Collectors.toList()).get(0))
                        .model(model)
                        .seater(seater)
                        .price(price)
                        .sold(sold)
                        .build();
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

}
