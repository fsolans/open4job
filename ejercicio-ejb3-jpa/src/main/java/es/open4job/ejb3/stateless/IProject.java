package es.open4job.ejb3.stateless;

import java.util.List;

import javax.ejb.Remote;

import es.open4job.ejercicio.model.Project;

@Remote
public interface IProject {

	void saveProject(Project project);

	Project findProject(Project project);

	List<Project> retrieveAllProjects();

}
