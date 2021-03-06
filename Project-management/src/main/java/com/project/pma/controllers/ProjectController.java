package com.project.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.pma.dao.EmployeeRepository;
import com.project.pma.dao.ProjectRepository;
import com.project.pma.entities.Employee;
import com.project.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proRep;
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRep.save(project);
		return "redirect:/projects";
	}
}
