package dev.patel.services;

import java.util.List;
import java.util.Set;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.daos.ReimburstmentDAOhibernate;
import dev.patel.daos.ReimburstmentDAO;
import dev.patel.entities.Reimburstment;

public class ReimburstmentServiceImpl implements ReimburstmentService {

	private EmployeeDAO edao;
	private ReimburstmentDAO rdao;
	
	
	
	public ReimburstmentServiceImpl() {
		super();
		this.edao = new EmployeeDAOhibernate();
		this.rdao = new ReimburstmentDAOhibernate();

	}
	
	public ReimburstmentServiceImpl(ReimburstmentDAO rdao, EmployeeDAO edao) {
		this.rdao = rdao;
		this.edao = edao;		
	}

	@Override
	public Reimburstment createReimburstment(Reimburstment reimburstment) {
		return this.rdao.createReimburstment(reimburstment);
	}

	@Override
	public Reimburstment getReimbursementById(int id) {
		return this.rdao.getReimburstmentById(id);
	}

	@Override
	public List<Reimburstment> getAllReimbursements() {
		return this.rdao.getAllReimburstments();
	}

	@Override
	public Reimburstment updateReimbursement(Reimburstment reimburstment) {
		return this.rdao.updateReimburstment(reimburstment);
	}

	@Override
	public boolean deleteReimbursement(Reimburstment reimburstment) {
		return this.rdao.deleteReimburstment(reimburstment);

	}

}
