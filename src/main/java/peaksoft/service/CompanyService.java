package peaksoft.service;

import peaksoft.entities.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Long id, Company company);
    void deleteCompany(Company company);
}
