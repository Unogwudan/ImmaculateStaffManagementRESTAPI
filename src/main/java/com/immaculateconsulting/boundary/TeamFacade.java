package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entities.Department;
import com.immaculateconsulting.entities.Team;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unogwudan
 */
@Stateless
public class TeamFacade extends AbstractFacade<Team> implements TeamFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_ImmaculateConsultingStaffManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamFacade() {
        super(Team.class);
    }

    @Override
    public List<Team> findByDepartment(Integer id) {
        return em.createNamedQuery("Team.findByDepartment", Team.class)
                .setParameter("departmentId", em.find(Department.class, id))
                .getResultList();
    }
    
}
