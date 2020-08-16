package dev.patel.app;

import dev.patel.controllers.EmployeeController;
import dev.patel.controllers.ManagerController;
import dev.patel.controllers.ReimburstmentController;
//import dev.patel.controllers.ReimbursementController;
import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> { // pass in a lambda that describes HOW to create the app

			config.enableCorsForAllOrigins();
			// config.addStaticFiles("/frontend");

		}).start(7000);

		// create operation employee
		app.post("/employees", EmployeeController.createEmployee);
		// create operation reimbursement
		app.post("/reimburstments", ReimburstmentController.createReimburstment);
		
		// read postman
		app.get("/employees", EmployeeController.getAllEmployees);
		app.get("/employees/:eid", EmployeeController.getEmployeeById);
		
		//---------------------------------------------------------------------------------------------------------------------------
		// read front end
		app.get("/login", EmployeeController.getEmployeeByUsername);
		app.get("/loginman", ManagerController.getManagerByUsername);
		
	   app.post("/employees/:eId/reimburstments", ReimburstmentController.createReimburstment);
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		app.get("/managers/:mid", ManagerController.getManagerById);
		// update operation
		
		app.put("/employees", EmployeeController.updateEmployee);
		app.put("/reimburstments/:rId", ReimburstmentController.updateReimbursement);
	
		
		
		app.get("/reimburstments", ReimburstmentController.getAllReimburstments);
		
		app.get("/employees/:eid/reimburstments/", ReimburstmentController.getAllReimbursementsFromEmployeeId);
		app.get("/managers/:mid/reimburstments/", ReimburstmentController.getAllReimburstments);
		
		// delete operation
		app.delete("/employees/:eid", EmployeeController.deleteEmployee);
		
		
		
		//Mixed
		
		//read
		 app.get("/employees/:eid/reimbursements",ReimburstmentController.getAllReimbursementsFromEmployeeId);
		 
		 //Front end
		 app.get("/create",ReimburstmentController.frontendcreateremimbursement);
		 					

	}// end main

}
