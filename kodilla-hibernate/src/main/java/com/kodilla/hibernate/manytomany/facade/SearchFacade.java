package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class SearchFacade {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    public List<Employee> searchForEmployee(String partOfFullName) throws SearchException {
        LOGGER.info("Start looking for employees whose full name contains " + partOfFullName);
        List<Employee> employeeList = employeeDao.searchForEmployee(partOfFullName);
        if (employeeList.size() == 0) {
            LOGGER.error(SearchException.EMPLOYEE_SEARCH_ERR);
            throw new SearchException(SearchException.EMPLOYEE_SEARCH_ERR);
        }
        return employeeList;
    }

    public List<Company> searchForCompany(String partOfTitle) throws SearchException {
        LOGGER.info("Start looking for companies whose title contains " + partOfTitle);
        List<Company> companyList = companyDao.searchForCompany(partOfTitle);
        if (companyList.size() == 0) {
            LOGGER.error(SearchException.COMPANY_SEARCH_ERR);
            throw new SearchException(SearchException.COMPANY_SEARCH_ERR);
        }
        return companyList;
    }
}
