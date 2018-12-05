package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.StaffFacadeLocal;
import com.immaculateconsulting.entiities.Staff;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Unogwudan
 */
@Stateless
@Path("staffs")
public class StaffFacadeREST {

    @EJB
    private StaffFacadeLocal staffFacadeLocal;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Staff entity) {
        staffFacadeLocal.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Staff entity) {
        staffFacadeLocal.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        staffFacadeLocal.remove(staffFacadeLocal.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Staff find(@PathParam("id") Integer id) {
        return staffFacadeLocal.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Staff> findAll() {
        return staffFacadeLocal.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Staff> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return staffFacadeLocal.findRange(new int[]{from, to});
    }
    
}
