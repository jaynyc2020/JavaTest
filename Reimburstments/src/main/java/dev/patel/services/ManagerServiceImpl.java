package dev.patel.services;

import java.util.List;
import java.util.Set;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ManagerDAO;
import dev.patel.daos.ManagerDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.daos.ReimburstmentDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.entities.Employee;
import dev.patel.entities.Manager;
import dev.patel.entities.Reimburstment;
import kotlin.Result;

public class ManagerServiceImpl implements  ManagerService {
	
	public EmployeeDAO edao = new EmployeeDAOhibernate();
	public ReimburstmentDAO rdao = new ReimburstmentDAOhibernate();
	public ManagerDAO mdao = new ManagerDAOhibernate();
	
	public ManagerServiceImpl() {
		super();
	}

	public ManagerServiceImpl(EmployeeDAO edao, ReimburstmentDAO rdao, ManagerDAO mdao){
		super();
		this.edao = edao;
		this.rdao = rdao;
		this.mdao = mdao;
	}

	@Override
	public Manager getManagerById(int id) {
		return this.mdao.getManagerById(id);
	}


	@Override
	public List<Manager> getAllManagers() {
		return this.mdao.getAllManagers();
	}

}
