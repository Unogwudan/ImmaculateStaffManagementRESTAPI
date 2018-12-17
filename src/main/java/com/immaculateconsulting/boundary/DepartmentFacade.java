package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entities.Department;
import com.immaculateconsulting.entities.Division;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unogwudan
 */
@Stateless
public class DepartmentFacade extends AbstractFacade<Department> implements DepartmentFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_ImmaculateConsultingStaffManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentFacade() {
        super(Department.class);
    }

    @Override
    public List<Department> findByDivision(Integer id) {
        return em.createNamedQuery("Department.findByDivision", Department.class)
                .setParameter("divisionId", em.find(Division.class, id))
                .getResultList();
    }
    
}
