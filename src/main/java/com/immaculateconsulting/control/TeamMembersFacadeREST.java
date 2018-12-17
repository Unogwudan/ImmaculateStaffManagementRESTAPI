package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.TeamMembersFacadeLocal;
import com.immaculateconsulting.entities.TeamMembers;
import com.immaculateconsulting.util.Messages;
import com.immaculateconsulting.util.StatusCode;
import com.immaculateconsulting.util.StatusMessage;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.SwaggerDefinition;
//import io.swagger.annotations.Tag;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Unogwudan
 */
@Path("teammembers")
//@Api("teammembers")
//@SwaggerDefinition(tags={@Tag(name="Team Members Resource", description="REST Endpoint for Team Members Resource")})
public class TeamMembersFacadeREST {

    @EJB
    private TeamMembersFacadeLocal teamMembersFacadeLocal;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(TeamMembers entity) {

        try {
            entity.setDateAdded(new Date());
            teamMembersFacadeLocal.create(entity);
            return Response.status(Response.Status.CREATED)
                    .entity(new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS))
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StatusMessage(StatusCode.ERROR, Messages.ERROR))
                    .build();
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response edit(TeamMembers entity) {

        try {
            teamMembersFacadeLocal.edit(entity);
            return Response.status(Response.Status.OK)
                    .entity(new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS))
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StatusMessage(StatusCode.ERROR, Messages.ERROR))
                    .build();
        }
    }

    @GET
    @Path("team/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TeamMembers> findByTeam(@PathParam("id") Integer id) {
        return teamMembersFacadeLocal.findByTeam(id);
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
