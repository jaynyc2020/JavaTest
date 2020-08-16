package dev.patel.services;

import dev.patel.entities.Employee;

import java.util.Set;
import dev.patel.entities.Reimburstment;
import java.util.List;

public interface ReimburstmentService {
	
	// create 
	Reimburstment createReimburstment(Reimburstment reimburstment);
	// read
	Reimburstment getReimbursementById(int id);
	List<Reimburstment> getAllReimbursements();
	
	//update
	Reimburstment updateReimbursement(Reimburstment reimburstment);
	
	//Delete
	boolean deleteReimbursement(Reimburstment reimburstment);
}
