package com.immaculateconsulting.boundary;

import com.immaculateconsulting.entities.Division;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unogwudan
 */
@Stateless
public class DivisionFacade extends AbstractFacade<Division> implements DivisionFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_ImmaculateConsultingStaffManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DivisionFacade() {
        super(Division.class);
    }
    
}
