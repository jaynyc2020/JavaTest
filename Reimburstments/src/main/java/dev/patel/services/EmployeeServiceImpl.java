package dev.patel.services;

import java.util.List;
import java.util.Set;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.daos.ReimburstmentDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.entities.Employee;
import dev.patel.entities.Reimburstment;
import kotlin.Result;
//import dev.patel.daos.EmployeeDAO;
//import dev.patel.daos.EmployeeDAOhibernate;
//import dev.ranieri.entities.Employee;
//import dev.ranieri.entities.Movie;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeDAO edao = new EmployeeDAOhibernate();
	public ReimburstmentDAO rdao = new ReimburstmentDAOhibernate();

	public EmployeeServiceImpl() {
		super();
	}

	public EmployeeServiceImpl(EmployeeDAO edao, ReimburstmentDAO rdao){
		super();
		this.edao = edao;
		this.rdao = rdao;

	}

	@Override
	public Employee createEmployee(Employee employee) {
		return this.edao.createEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return this.edao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.edao.getAllEmployees();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.edao.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return this.edao.deleteEmployee(employee);

	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		List<Employee> employees = edao.getAllEmployees();

		for (Employee employee : employees) {
			if (employee.getUsername() == username)
				return employee;

		}
		return null;

	}
	/*
	public void getReimbursementsByEmployeeId(int eid) {
		List<Reimbursement> reimbursements = rdao.getAllReimbursements();
		Employee employee = edao.getEmployeeById(eid);
		List<Reimbursement> empReimbursements = null; 
		for (Reimbursement reimbursement : reimbursements) {
			if (reimbursement.getEmpId() == eid)
				empReimbursements.add(reimbursement);
				

		}
		employee.setReimbursement(empReimbursements);
	
	}
	
	*/

}
