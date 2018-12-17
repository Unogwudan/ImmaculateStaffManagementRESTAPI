package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.TeamFacadeLocal;
import com.immaculateconsulting.entities.Team;
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
@Path("teams")
//@Api("teams")
//@SwaggerDefinition(tags={@Tag(name="Teams Resource", description="REST Endpoint for Teams Resource")})
public class TeamFacadeREST {

    @EJB
    private TeamFacadeLocal teamFacadeLocal;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Team entity) {
        try {
            entity.setDateAdded(new Date());
            teamFacadeLocal.create(entity);
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
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response edit(@PathParam("id") Integer id, Team entity) {
        try {
            teamFacadeLocal.edit(entity);
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
    @Path("department/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Team> findByTeam(@PathParam("id") Integer id) {
        return teamFacadeLocal.findByDepartment(id);
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
