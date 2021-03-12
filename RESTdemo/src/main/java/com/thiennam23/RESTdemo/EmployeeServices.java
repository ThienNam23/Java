package com.thiennam23.RESTdemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeServices {
	
	private EmployeeDao employeeDao = new EmployeeDao();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}
	
	@GET
	@Path("employee/{eid}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Employee getEmployee(@PathParam("eid") int eid) {
		return employeeDao.getEmployee(eid);
	}
	
	@POST
	@Path("employee")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Employee creatEmployee(Employee employee) {
		employeeDao.create(employee);
		return employee;
	}
	
	@PUT
	@Path("employee")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Employee updateEmployee(Employee employee) {
		if (employeeDao.getEmployee(employee.getEid()).getEid() == 0) {
			employeeDao.create(employee);
		}
		else {
			employeeDao.update(employee);
		}
		return employee;
	}
	
	@DELETE
	@Path("employee/{eid}")
	public Employee deleteEmployee(@PathParam("eid") int eid) {
		Employee e1 = employeeDao.getEmployee(eid);
		
		if (e1.getEid() != 0) {
			employeeDao.delete(eid);
		}
		return e1;
	}
}
