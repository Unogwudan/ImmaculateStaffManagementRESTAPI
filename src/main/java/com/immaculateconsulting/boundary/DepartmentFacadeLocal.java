package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entiities.Department;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unogwudan
 */
@Local
public interface DepartmentFacadeLocal {

    void create(Department department);

    void edit(Department department);

    void remove(Department department);

    Department find(Object id);

    List<Department> findAll();

    List<Department> findRange(int[] range);

    int count();
    
}
