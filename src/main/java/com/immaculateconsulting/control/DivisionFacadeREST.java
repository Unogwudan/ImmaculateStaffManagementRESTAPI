package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.DivisionFacadeLocal;
import com.immaculateconsulting.entities.Division;
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
@Path("divisions")
//@Api("divisions")
//@SwaggerDefinition(tags={@Tag(name="Division Resource", description="REST Endpoint for Division Resource")})
public class DivisionFacadeREST {

    @EJB
    private DivisionFacadeLocal divisionFacadeLocal;
    private StatusMessage response;

    /**
     * Create a division and set the unit head on it
     *
     * @param entity division object to create
     * @return either a success or error payload
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Division entity) {
        try {
            entity.setDateAdded(new Date());
            divisionFacadeLocal.create(entity);
            return Response.status(Response.Status.CREATED)
                    .entity(new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS))
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StatusMessage(StatusCode.ERROR, Messages.ERROR))
                    .build();
        }
    }

    /**
     * Update a division in the company
     *
     * @param entity division to edit
     * @return either a success or error payload
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response edit(Division entity) {
        try {
            divisionFacadeLocal.edit(entity);
            return Response.status(Response.Status.OK)
                    .entity(new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS))
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StatusMessage(StatusCode.ERROR, Messages.ERROR))
                    .build();
        }
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
