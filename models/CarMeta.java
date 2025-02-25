package Test.models;

import java.util.List;

import Test.DaoImpl.CompanyDaoImpl;
import Test.DaoImpl.FuelDaoImpl;
import Test.DaoImpl.TypeDaoImpl;
import Test.repository.CompanyRepo;
import Test.repository.FuelRepo;
import Test.repository.TypeRepo;

public class CarMeta {

    private static CarMeta carmeta;

    private List<Fuel> fuel;
    private List<Company> company;
    private List<Type> type;

    private CompanyRepo cr = new CompanyDaoImpl();
    private TypeRepo tr = new TypeDaoImpl();
    private FuelRepo fr = new FuelDaoImpl();

    public List<Fuel> getFuel() {
        return fuel;
    }

    public List<Company> getCompany() {
        return company;
    }

    public List<Type> getType() {
        return type;
    }

    private CarMeta() {
        fuel = fr.getAllFuelType();
        company = cr.getAllCompanies();
        type = tr.getAllTypes();
    }

    public static CarMeta getCarMeta() {
        if (carmeta == null) {
            carmeta = new CarMeta();
        }
        return carmeta;
    }

}
