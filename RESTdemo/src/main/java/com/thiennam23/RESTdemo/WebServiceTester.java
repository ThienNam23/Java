package com.thiennam23.RESTdemo;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class WebServiceTester {

	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/RESTdemo/webapi/employees/employee";
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	private void init() {
		this.client = ClientBuilder.newClient();
	}

	// Test: Get list of all users
	// Test: Check if list is not empty
	private void testGetAllEmployees() {
		GenericType<List<Employee>> list = new GenericType<List<Employee>>() {
		};
		List<Employee> employees = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (employees.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllEmployees, Result: " + result);
	}

	// Test: Get Employee of id 1
	// Test: Check if user is same as sample user
	private void testGetEmployee() {
		Employee sampleEmployee = new Employee();
		sampleEmployee.setEid(1);

		Employee employee = client.target(REST_SERVICE_URL).path("/{eid}").resolveTemplate("eid", 1)
				.request(MediaType.APPLICATION_XML).get(Employee.class);
		String result = FAIL;
		if (sampleEmployee != null && sampleEmployee.getEid() == employee.getEid()) {
			result = PASS;
		}
		System.out.println("Test case name: testGetEmployee, Result: " + result);
	}

	// Test: Update Employee of id 1
	// Test: Check if result is success XML.
	private void testUpdateEmployee() {
		Form form = new Form();
		form.param("eid", "1");
		form.param("ename", "Gater");
		form.param("salary", "46000");
		form.param("deg", "DevOps");

		String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testUpdateEmployee, Result: " + result);
	}

	// Test: Add Employee of id 2
	// Test: Check if result is success XML.
	private void testAddEmployee() {
		Form form = new Form();
		form.param("eid", "1");
		form.param("ename", "Gater");
		form.param("salary", "46000");
		form.param("deg", "DevOps");

		String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testAddEmployee, Result: " + result);
	}

	// Test: Delete Employee of id 2
	// Test: Check if result is success XML.
	private void testDeleteEmployee() {
		String callResult = client.target(REST_SERVICE_URL).path("/{eid}").resolveTemplate("eid", 2)
				.request(MediaType.APPLICATION_XML).delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testDeleteEmployee, Result: " + result);
	}

	public static void main(String[] args) {
		WebServiceTester tester = new WebServiceTester();
		// initialize the tester
		tester.init();
		// test get all users Web Service Method
		tester.testGetAllEmployees();
		// test get user Web Service Method
		tester.testGetEmployee();
		// test update user Web Service Method
		tester.testUpdateEmployee();
		// test add user Web Service Method
		tester.testAddEmployee();
		// test delete user Web Service Method
		tester.testDeleteEmployee();
	}
}
