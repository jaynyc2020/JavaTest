package dev.patel.services;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ManagerDAO;
import dev.patel.daos.ManagerDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.daos.ReimburstmentDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.entities.Employee;
import dev.patel.entities.Manager;

import java.util.Set;
import java.util.List;


public interface ManagerService {
	
	public EmployeeDAO edao = new EmployeeDAOhibernate();
	public ReimburstmentDAO rdao = new ReimburstmentDAOhibernate();
	public ManagerDAO mdao = new ManagerDAOhibernate();
	
	Manager getManagerById(int id);
	List<Manager> getAllManagers();
	
}
