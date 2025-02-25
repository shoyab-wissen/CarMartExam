package Test.repository;

import java.util.List;

import Test.models.Company;

public interface CompanyRepo {
    public List<Company> getAllCompanies();

    public Boolean addCompany(Company company);
}
