package Test.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import Test.models.Fuel;
import Test.repository.FuelRepo;
import Test.util.DatabaseHandler;

public class FuelDaoImpl implements FuelRepo {
    private static JdbcRowSet rowset = DatabaseHandler.getHandler();

    public List<Fuel> getAllFuelType() {
        List<Fuel> fuels = new ArrayList<Fuel>();
        try {
            rowset.setCommand("select * from fuel");
            rowset.execute();
            rowset.beforeFirst();
            while (rowset.next()) {
                Fuel fuel = new Fuel();
                fuel.setFuelType(rowset.getString("fuel_name"));
                fuels.add(fuel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fuels;
    }

    public Boolean addFuelType(Fuel fuel) {
        try {
            rowset.moveToInsertRow();
            rowset.updateString("fuel_name", fuel.getFuelType());
            rowset.insertRow();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
