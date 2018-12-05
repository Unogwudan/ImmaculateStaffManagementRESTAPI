package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.DepartmentFacadeLocal;
import com.immaculateconsulting.entiities.Department;
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
@Path("departments")
public class DepartmentFacadeREST {
    
    @EJB
    private DepartmentFacadeLocal departmentFacadeLocal;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Department entity) {
        departmentFacadeLocal.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Department entity) {
        departmentFacadeLocal.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        departmentFacadeLocal.remove(departmentFacadeLocal.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Department find(@PathParam("id") Integer id) {
        return departmentFacadeLocal.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Department> findAll() {
        return departmentFacadeLocal.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Department> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return departmentFacadeLocal.findRange(new int[]{from, to});
    }
    
}
