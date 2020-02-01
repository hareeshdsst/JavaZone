package com.project.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.pma.dto.ChartData;
import com.project.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>
{
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true,value="SELECT stage  as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY  stage")
    public List<ChartData> getProjectStatus();
}
