package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.TeamMembersFacadeLocal;
import com.immaculateconsulting.entiities.TeamMembers;
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
@Path("teammembers")
public class TeamMembersFacadeREST {
    
    @EJB
    private TeamMembersFacadeLocal teamMembersFacadeLocal;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(TeamMembers entity) {
        teamMembersFacadeLocal.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, TeamMembers entity) {
        teamMembersFacadeLocal.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        teamMembersFacadeLocal.remove(teamMembersFacadeLocal.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TeamMembers find(@PathParam("id") Integer id) {
        return teamMembersFacadeLocal.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TeamMembers> findAll() {
        return teamMembersFacadeLocal.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TeamMembers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return teamMembersFacadeLocal.findRange(new int[]{from, to});
    }

}
