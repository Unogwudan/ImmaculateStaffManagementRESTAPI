package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entiities.Staff;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unogwudan
 */
@Local
public interface StaffFacadeLocal {

    void create(Staff staff);

    void edit(Staff staff);

    void remove(Staff staff);

    Staff find(Object id);

    List<Staff> findAll();

    List<Staff> findRange(int[] range);

    int count();
    
}
