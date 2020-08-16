package dev.patel.controllers;

import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.patel.entities.Employee;
import dev.patel.entities.Reimburstment;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import dev.patel.services.ReimburstmentService;
import dev.patel.services.ReimburstmentService;
import dev.patel.services.ReimburstmentServiceImpl;
import io.javalin.http.Handler;
import com.google.gson.Gson;

public class ReimburstmentController {

	private static ReimburstmentService rserv = new ReimburstmentServiceImpl();
	private static EmployeeService eserv = new EmployeeServiceImpl();
	private static Gson gson = new Gson();

	public static Handler createReimburstment = (ctx) -> {
		String reimburstmentJson = ctx.body();
		Reimburstment reimburstment = gson.fromJson(reimburstmentJson, Reimburstment.class);
		rserv.createReimburstment(reimburstment);
		ctx.status(201);
		ctx.result(gson.toJson(reimburstment));

	};

	public static Handler getAllReimbursementsFromEmployeeId = (ctx) -> {
		String id = ctx.pathParam("eid");
		int empid = Integer.parseInt(id);
		System.out.println(empid);
		List<Reimburstment> reimburstments = rserv.getAllReimbursements();
		ArrayList<Reimburstment> a = new ArrayList<Reimburstment>(reimburstments);
		Iterator<Reimburstment> itr = a.iterator();

		while (itr.hasNext()) {
			Reimburstment loan = itr.next();
			if (loan.getEmpId() != empid) {
				itr.remove();
			}
		}
		for (Reimburstment reimburstment : a) {
			if (reimburstment.getEmpId() != empid)
				a.remove(reimburstment);

		}

		// if (employee == null) {
		// ctx.status(404);
		// } else {
		String json = gson.toJson(a);
		ctx.result(json);
	};
	
	
	
	public static Handler getAllReimburstments = (ctx) -> {
		List<Reimburstment> reimburstments = rserv.getAllReimbursements();
		for(Reimburstment reimburstment: reimburstments)
		{
			System.out.println(reimburstment.toString());
		}
		
		String json = gson.toJson(reimburstments);
		ctx.result(json);
	};
	
	
	
	public static Handler frontendcreateremimbursement = (ctx) -> {
		String Id = ctx.queryParam("rId");
		String amo = ctx.queryParam("amount");
		String sta = ctx.queryParam("status");
		String not = ctx.queryParam("note");
		String eId = ctx.queryParam("empId");
		System.out.println(Id + " " + amo + " " + sta + " " + not + "" + eId);
		int reid = Integer.parseInt(Id);
		double am = Integer.parseInt(amo);
		int eeId = Integer.parseInt(eId);
		Reimburstment reimburstment = new Reimburstment(reid,am,sta,not,eeId);
		rserv.createReimburstment(reimburstment);
		ctx.status(201);
		ctx.result(gson.toJson(reimburstment));
		
		
	};//end method
	
	public static Handler updateReimbursement = (ctx) -> {
		
		String reimburstmentJson = ctx.body();
		Reimburstment reimburstment = gson.fromJson(reimburstmentJson, Reimburstment.class);
		//reimburstment.setempId(reimburstment.getEmpId());
	
		
	//	reimburstment.toString();
		
		reimburstment = rserv.updateReimbursement(reimburstment);
		ctx.result(gson.toJson(reimburstment));
		 
	};
	
	
	
	

}// end class
