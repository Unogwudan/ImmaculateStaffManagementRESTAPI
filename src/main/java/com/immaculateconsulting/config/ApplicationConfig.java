package com.immaculateconsulting.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Unogwudan
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.immaculateconsulting.config.CrossOriginResourceSharingFilter.class);
        resources.add(com.immaculateconsulting.control.DepartmentFacadeREST.class);
        resources.add(com.immaculateconsulting.control.DivisionFacadeREST.class);
        resources.add(com.immaculateconsulting.control.StaffFacadeREST.class);
        resources.add(com.immaculateconsulting.control.TeamFacadeREST.class);
        resources.add(com.immaculateconsulting.control.TeamMembersFacadeREST.class);
    }
    
}
