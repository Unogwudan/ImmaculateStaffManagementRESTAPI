package com.immaculateconsulting.control;

import com.immaculateconsulting.boundary.StaffFacadeLocal;
import com.immaculateconsulting.entiities.Staff;
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
@Path("staffs")
public class StaffFacadeREST {

    @EJB
    private StaffFacadeLocal staffFacadeLocal; 
    private StatusMessage response;

    /**
     * Register a new staff
     * @param entity contains staff object to persist
     * @return a success or error payload
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Staff entity) {
        try {
            entity.setDateAdded(new Date());
            // Persist the staff
            staffFacadeLocal.create(entity);
            
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

    /**
     * Update a staff's details 
     * @param entity staff details to be updated
     * @return either a success or error payload
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response edit(Staff entity) {
        try {
            // Edit the staff
            staffFacadeLocal.edit(entity);
            
            response = new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS);
            return Response.status(Response.Status.OK)
                    .entity(response)
                    .build();
        } catch(Exception e) {
            response = new StatusMessage(StatusCode.ERROR, Messages.ERROR);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(response)
                    .build();
        }
        
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
