package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entities.TeamMembers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unogwudan
 */
@Local
public interface TeamMembersFacadeLocal {

    void create(TeamMembers teamMembers);

    void edit(TeamMembers teamMembers);

    void remove(TeamMembers teamMembers);

    TeamMembers find(Object id);

    List<TeamMembers> findAll();

    List<TeamMembers> findRange(int[] range);

    int count();
    
    List<TeamMembers> findByTeam(Integer id);
    
}
