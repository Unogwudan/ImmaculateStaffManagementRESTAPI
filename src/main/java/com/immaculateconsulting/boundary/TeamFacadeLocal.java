package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entities.Team;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unogwudan
 */
@Local
public interface TeamFacadeLocal {

    void create(Team team);

    void edit(Team team);

    void remove(Team team);

    Team find(Object id);

    List<Team> findAll();

    List<Team> findRange(int[] range);

    int count();

    List<Team> findByDepartment(Integer id);
    
}
