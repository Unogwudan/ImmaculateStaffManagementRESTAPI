package com.immaculateconsulting.control;

import com.immaculateconsulting.entities.Employee;
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
import com.immaculateconsulting.boundary.EmployeeFacadeLocal;

/**
 *
 * @author Unogwudan
 */
@Path("employees")
//@Api("staffs")
//@SwaggerDefinition(tags={@Tag(name="Staffs Resource", description="REST Endpoint for Staffs Resource")})
public class EmployeeFacadeREST {

    @EJB
    private EmployeeFacadeLocal employeeFacadeLocal; 
    private StatusMessage response;

    /**
     * Register a new employee
     * @param entity contains employee object to persist
     * @return a success or error payload
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createEmployee(Employee entity) {
        try {
            entity.setDateAdded(new Date());
            // Persist the employee
            employeeFacadeLocal.create(entity);

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
     * Update an employee's details 
     * @param entity employee details to be updated
     * @return either a success or error payload
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response editEmployee(Employee entity) {
        try {
            // Edit the employee
            employeeFacadeLocal.edit(entity);
            
            return Response.status(Response.Status.OK)
                    .entity(new StatusMessage(StatusCode.SUCCESS, Messages.SUCCESS))
                    .build();
        } catch(Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StatusMessage(StatusCode.ERROR, Messages.ERROR))
                    .build();
        }
        
    }

    @DELETE
    @Path("{id}")
    public void deleteEmployee(@PathParam("id") Integer id) {
        employeeFacadeLocal.remove(employeeFacadeLocal.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee find(@PathParam("id") Integer id) {
        return employeeFacadeLocal.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Employee> findAll() {
        return employeeFacadeLocal.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Employee> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return employeeFacadeLocal.findRange(new int[]{from, to});
    }

}
