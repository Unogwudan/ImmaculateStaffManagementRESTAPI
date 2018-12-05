package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entiities.TeamMembers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unogwudan
 */
@Stateless
public class TeamMembersFacade extends AbstractFacade<TeamMembers> implements TeamMembersFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_ImmaculateConsultingStaffManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamMembersFacade() {
        super(TeamMembers.class);
    }
    
}
