package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entiities.Division;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unogwudan
 */
@Local
public interface DivisionFacadeLocal {

    void create(Division division);

    void edit(Division division);

    void remove(Division division);

    Division find(Object id);

    List<Division> findAll();

    List<Division> findRange(int[] range);

    int count();
    
}
