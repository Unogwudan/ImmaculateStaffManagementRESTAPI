package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.DivisionFacadeLocal;
import com.immaculateconsulting.entiities.Division;
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
@Path("divisions")
public class DivisionFacadeREST {

    @EJB
    private DivisionFacadeLocal divisionFacadeLocal;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Division entity) {
        divisionFacadeLocal.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Division entity) {
        divisionFacadeLocal.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        divisionFacadeLocal.remove(divisionFacadeLocal.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Division find(@PathParam("id") Integer id) {
        return divisionFacadeLocal.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Division> findAll() {
        return divisionFacadeLocal.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Division> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return divisionFacadeLocal.findRange(new int[]{from, to});
    }
    
}
