package com.immaculateconsulting.config;

//import io.swagger.jaxrs.config.BeanConfig;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Unogwudan
 */
@ApplicationPath("api")
public class ApplicationConfig extends Application {

    public ApplicationConfig(){
//        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setBasePath("/ImmaculateConsultingStaffManagement/api");
//        beanConfig.setHost("localhost:8080");
//        beanConfig.setTitle("Immaculate Consulting Staff Management Swagger Docs");
//        beanConfig.setResourcePackage("com.immaculateconsulting");
//        beanConfig.setPrettyPrint(true);
//        beanConfig.setScan(true);
//        beanConfig.setSchemes(new String[] {"http"});
//        beanConfig.setVersion("2.0");
    }
    
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
        resources.add(com.immaculateconsulting.control.EmployeeFacadeREST.class);
        resources.add(com.immaculateconsulting.control.TeamFacadeREST.class);
        resources.add(com.immaculateconsulting.control.TeamMembersFacadeREST.class);
    }
    
}
