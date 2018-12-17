package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entities.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unogwudan
 */
@Local
public interface EmployeeFacadeLocal {

    void create(Employee staff);

    void edit(Employee staff);

    void remove(Employee staff);

    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);
    
}
