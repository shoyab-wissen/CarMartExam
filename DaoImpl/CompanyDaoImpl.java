package Test.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import Test.models.Company;
import Test.repository.CompanyRepo;
import Test.util.DatabaseHandler;

public class CompanyDaoImpl implements CompanyRepo {

    private static JdbcRowSet rowset = DatabaseHandler.getHandler();

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        try {
            rowset.setCommand("select * from company");
            rowset.execute();
            rowset.beforeFirst();
            while (rowset.next()) {
                Company company = new Company();
                company.setName(rowset.getString("company_name"));
                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public Boolean addCompany(Company company) {
        try {
            rowset.moveToInsertRow();
            rowset.updateString("company_name", company.getName());
            rowset.insertRow();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
