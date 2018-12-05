package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.TeamFacadeLocal;
import com.immaculateconsulting.entiities.Team;
import java.util.List;
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
@Path("teams")
public class TeamFacadeREST {

    private TeamFacadeLocal teamFacadeLocal;
            
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Team entity) {
        teamFacadeLocal.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Team entity) {
        teamFacadeLocal.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        teamFacadeLocal.remove(teamFacadeLocal.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Team find(@PathParam("id") Integer id) {
        return teamFacadeLocal.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Team> findAll() {
        return teamFacadeLocal.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Team> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return teamFacadeLocal.findRange(new int[]{from, to});
    }

}
