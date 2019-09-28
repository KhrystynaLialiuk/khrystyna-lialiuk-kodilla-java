package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SearchFacade searchFacade;

    @Test
    public void testSearchForEmployee() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee mirandaClarckson = new Employee("Miranda", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        employeeDao.save(johnSmith);
        employeeDao.save(mirandaClarckson);
        employeeDao.save(lindaKovalsky);

        //When
        try {
            List<Employee> foundEmployees = searchFacade.searchForEmployee("mi");

            //Then
            Assert.assertEquals(2, foundEmployees.size());
        } catch (SearchException e) {
            System.out.println(e.getMessage());
        } finally {

            //CleanUp
            employeeDao.deleteById(johnSmith.getId());
            employeeDao.deleteById(mirandaClarckson.getId());
            employeeDao.deleteById(lindaKovalsky.getId());
        }
    }

    @Test
    public void testSearchForCompany() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When
        try {
            List<Company> foundCompanies = searchFacade.searchForCompany("ter");

            //Then
            Assert.assertEquals(2, foundCompanies.size());
        } catch (SearchException e) {
            System.out.println(e.getMessage());
        } finally {
            companyDao.deleteById(softwareMachine.getId());
            companyDao.deleteById(dataMaesters.getId());
            companyDao.deleteById(greyMatter.getId());
        }
    }
}
