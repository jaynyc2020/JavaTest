package dev.patel.daotests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.daos.ReimburstmentDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.entities.Employee;
import dev.patel.entities.Reimburstment;
import dev.patel.daos.EmployeeDAOhibernate;

@TestMethodOrder(OrderAnnotation.class) 
public class ReimbursementDAOtests {
	
	private static ReimburstmentDAO rdao = new ReimburstmentDAOhibernate();
	private static EmployeeDAO edao = new EmployeeDAOhibernate();
	// Execute once
	

	
	
	@Test
	@Order(1)
	void createReimbursement() { 
		// an object with an ID of 0 is understood to not be a record in the database
		//Employee employee = edao.getEmployeeById(2);
		Reimburstment reimburstment = new Reimburstment(0,1.0,"Pending", "na", 2 );
		rdao.createReimburstment(reimburstment);
		Assertions.assertNotEquals(0, reimburstment.getrId());
	}
	
	
	@Test
	@Order(2)
	void getReimbursementById() {
		Reimburstment reimburstment = rdao.getReimburstmentById(1);
		Assertions.assertEquals(1, reimburstment.getrId());
	}
	
	@Test
	@Order(3)
	void updateReimbursement() {
		Reimburstment reimburstment = rdao.getReimburstmentById(1);
		reimburstment.setAmount(2);
		rdao.updateReimburstment(reimburstment);	
		Assertions.assertEquals(2,reimburstment.getAmount());
	}
	
	@Test
	@Order(4)
	void getAllReimbursements() {
		
		
		List<Reimburstment> remimbursement = rdao.getAllReimburstments();
		Assertions.assertEquals(1,remimbursement.size());
	}
	
	
	
	
	@Test
	@Order(5)
	void deleteReimbursement() {
		Reimburstment reimburstment = rdao.getReimburstmentById(1);	
		boolean result = rdao.deleteReimburstment(reimburstment);
		Assertions.assertEquals(true,result);
		
		Employee employee = edao.getEmployeeById(2);	
		boolean res = edao.deleteEmployee(employee);

	}
	

}
