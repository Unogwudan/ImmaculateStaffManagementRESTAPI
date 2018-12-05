package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.DepartmentFacadeLocal;
import com.immaculateconsulting.entiities.Department;
import com.immaculateconsulting.util.Messages;
import com.immaculateconsulting.util.StatusCode;
import com.immaculateconsulting.util.StatusMessage;
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
@Path("departments")
public class DepartmentFacadeREST {

    @EJB
    private DepartmentFacadeLocal departmentFacadeLocal;
    private StatusMessage response;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Department entity) {
        try {
            entity.setDateAdded(new Date());
            departmentFacadeLocal.create(entity);
            response = new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS);
            return Response.status(Response.Status.CREATED)
                    .entity(response)
                    .build();
            
        } catch (Exception e) {
            response = new StatusMessage(StatusCode.ERROR, Messages.ERROR);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(response)
                    .build();
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response edit(Department entity) {
        try {
            departmentFacadeLocal.edit(entity);
            response = new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS);
            return Response.status(Response.Status.OK)
                    .entity(response)
                    .build();

        } catch (Exception e) {
            response = new StatusMessage(StatusCode.ERROR, Messages.ERROR);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(response)
                    .build();
        }

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
