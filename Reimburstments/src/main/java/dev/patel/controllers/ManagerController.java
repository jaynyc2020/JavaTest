package dev.patel.controllers;

import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import dev.patel.entities.Employee;
import dev.patel.entities.Manager;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import dev.patel.services.ManagerService;
import dev.patel.services.ManagerServiceImpl;
import io.javalin.http.Handler;


public class ManagerController {
	
	public static ManagerService mserv = new ManagerServiceImpl();
	private static Gson gson = new Gson();

	public static Handler getManagerByUsername = (ctx) -> {

		String userQ = ctx.queryParam("username");
		String passQ = ctx.queryParam("password");
		//System.out.println(userQ);
		//System.out.println(passQ);
		List<Manager> managers = mserv.getAllManagers();
		for (Manager manager : managers) {
		//	System.out.println(employee.toString());
			//System.out.println(employee.getUsername());
			//System.out.println(employee.getClass().getName());
			
			String un = manager.getUsername();
			String pw = manager.getPassword();
		//	System.out.println((un.equals(userQ)));
			if (un.equals(userQ)) {
				if(pw.equals(passQ)) {
					manager.toString();
					String json = gson.toJson(manager);
					ctx.result(json);
					return;
				}
			}
			ctx.status(404);
		}

	};
	
	public static Handler getManagerById = (ctx) -> {
		//System.out.println("eid");
		String id = ctx.pathParam("mid");
		Manager manager = mserv.getManagerById(Integer.parseInt(id));
		if (manager == null) {
			ctx.status(404);
		} else {
			String json = gson.toJson(manager);
			ctx.result(json);
		}

	};

}
