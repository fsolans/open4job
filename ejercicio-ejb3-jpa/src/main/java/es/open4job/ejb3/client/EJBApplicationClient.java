package es.open4job.ejb3.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import es.open4job.ejb3.stateless.IProject;
import es.open4job.ejb3.stateless.ProjectBean;
import es.open4job.ejercicio.model.Project;
 
public class EJBApplicationClient {

	   public static void main(String[] args) {
		   
	        IProject bean = doLookup();
	         
	        Project p1 = new Project();
	        p1.setPname("Banking App");
	        p1.setPlocation("Town City");
	        p1.setDeptNo(1);
	         
	        Project p2 = new Project();
	        p2.setPname("Office Automation");
	        p2.setPlocation("Downtown");
	        p2.setDeptNo(2);
	 
	        // 4. Call business logic
	        //Saving new Projects
	        bean.saveProject(p1);
	        bean.saveProject(p2);
	         
	        //Find a Project
	        p1.setPnumber(1);
	        Project p3 = bean.findProject(p1);
	        System.out.println(p3);
	         
	        //Retrieve all projects
	       System.out.println("List of Projects:");
	        List<Project> projects = bean.retrieveAllProjects();
	        for(Project project : projects)
	            System.out.println(project);
	         
	    }
	 
	    private static IProject doLookup() {
	       
	    	Context context = null;
	        IProject bean = null;
	        
	        try {
	        
	        	// 1. Obtaining Context
	            context = JNDILookupClass.getInitialContext();
	            
	            // 2. Generate JNDI Lookup name
	            String lookupName = getLookupName();
	            
	            // 3. Lookup and cast
	            bean = (IProject) context.lookup(lookupName);
	 
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	        
	        return bean;
	    
	    }
	 
	    private static String getLookupName() {
	    
	    	/*The app name is the EAR name of the deployed EJB without .ear
	        suffix. Since we haven't deployed the application as a .ear, the app
	        name for us will be an empty string */
	        String appName = "";
	 
	        /* The module name is the JAR name of the deployed EJB without the
	        .jar suffix.*/
	        String moduleName = "ejercicio-ejb3-jpa";
	 
	        /* AS7 allows each deployment to have an (optional) distinct name.
	        This can be an empty string if distinct name is not specified.*/
	        String distinctName = "";
	 
	        // The EJB bean implementation class name
	        String beanName = ProjectBean.class.getSimpleName();
	 
	        // Fully qualified remote interface name
	        final String interfaceName = IProject.class.getName();
	 
	        // Create a look up string name
	        String name = "ejb:" + appName + "/" + moduleName + "/" +
	                distinctName    + "/" + beanName + "!" + interfaceName;
	        
	        return name;
	    }
	    
}
