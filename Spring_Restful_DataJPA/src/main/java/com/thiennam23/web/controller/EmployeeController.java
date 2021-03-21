package com.thiennam23.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thiennam23.web.model.Employee;
import com.thiennam23.web.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	
	EmployeeRepo empRepo = new EmployeeRepo();
	
	@RequestMapping(path = "/employee", method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		System.out.println(employee);
		empRepo.addEmployee(employee);
		
		return new ModelAndView("show.jsp").addObject("employee", employee);
	}
	
	@GetMapping(path = "/employees", produces = {MediaType.APPLICATION_XML_VALUE})
	public List<Employee> getEmployees() {
		return empRepo.findAllEmployees();
	}
	
	@RequestMapping(path = "/employee/{eid}")
	@ResponseBody
	public Employee getEmployee(@PathVariable("eid") int eid) {
		
		return empRepo.findById(eid);
	}
	
	@DeleteMapping(path = "/employee/{eid}")
	public String deleteEmployee(@PathVariable int eid) {
		
		empRepo.deleteById(eid);
		
		return eid +  ": Deleted!";
	}
	
	@PutMapping(path = "/employee", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Employee updateEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		empRepo.updateEmployee(employee);
		return employee;
	}
}
