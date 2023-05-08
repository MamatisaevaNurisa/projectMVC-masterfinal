package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CompanyDao;
import peaksoft.entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = manager.createQuery("From Company", Company.class).getResultList();
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        manager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        Company company = manager.find(Company.class, id);
        return company;
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Company company1 = getCompanyById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        manager.merge(company1);
    }

    @Override
    public void deleteCompany(Company company) {
        manager.remove(manager.contains(company)? company : manager.merge(company));
    }
}
