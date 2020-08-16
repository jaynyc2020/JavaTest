package dev.patel.controllers;

import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import dev.patel.entities.Employee;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import io.javalin.http.Handler;

public class EmployeeController {

	public static EmployeeService eserv = new EmployeeServiceImpl();
	private static Gson gson = new Gson();

	public static Handler createEmployee = (ctx) -> {
		// context object ctx is an object that contains the http request and response
		// objects
		// it contains a whole bunch of method for dealing with getting information from
		// the request
		// and sending information in the http response

		String employeeJson = ctx.body();
		Employee employee = gson.fromJson(employeeJson, Employee.class); // transform the json into a Shcool object
		eserv.createEmployee(employee);
		ctx.status(201); // 201 is the status code to return if you successfully add something

		// usually you want to return the created object
		ctx.result(gson.toJson(employee));
	};

	public static Handler getEmployeeById = (ctx) -> {
		System.out.println("eid");
		String id = ctx.pathParam("eid");
		Employee employee = eserv.getEmployeeById(Integer.parseInt(id));
		if (employee == null) {
			ctx.status(404);
		} else {
			String json = gson.toJson(employee);
			ctx.result(json);
		}

	};

	public static Handler getEmployeeByUsername = (ctx) -> {

		String userQ = ctx.queryParam("username");
		String passQ = ctx.queryParam("password");
		//System.out.println(userQ);
		//System.out.println(passQ);
		List<Employee> employees = eserv.getAllEmployees();
		for (Employee employee : employees) {
		//	System.out.println(employee.toString());
			//System.out.println(employee.getUsername());
			//System.out.println(employee.getClass().getName());
			
			String un = employee.getUsername();
			String pw = employee.getPassword();
		//	System.out.println((un.equals(userQ)));
			if (un.equals(userQ)) {
				if(pw.equals(passQ)) {
					employee.toString();
					String json = gson.toJson(employee);
					ctx.result(json);
					return;
				}
			}
			ctx.status(404);
		}

	};

	public static Handler getAllEmployees = (ctx) -> {
		List<Employee> employees = eserv.getAllEmployees();
		String json = gson.toJson(employees);
		ctx.result(json);

	};

	public static Handler updateEmployee = (ctx) -> {
		String employeeJson = ctx.body();
		Employee employee = gson.fromJson(employeeJson, Employee.class);
		eserv.updateEmployee(employee);
		ctx.result(gson.toJson(employee));
	};

	public static Handler deleteEmployee = (ctx) -> {
		String id = ctx.pathParam("eid");
		Employee employee = eserv.getEmployeeById(Integer.parseInt(id));
		boolean result = eserv.deleteEmployee(employee);

	};

}
