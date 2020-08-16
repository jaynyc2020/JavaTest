package dev.patel.daos;

import java.util.Set;
import java.util.List;

import dev.patel.entities.Reimburstment;

public interface ReimburstmentDAO {

	// Create
	Reimburstment createReimburstment(Reimburstment reimburstment);

	// read
	List<Reimburstment> getAllReimburstments();

	Reimburstment getReimburstmentById(int id);
	
	//List<Reimbursement> getReimbursementsByEmployeeId(int id);

	//Set<Employee> getEmployeesBySchoolId(int id);

	// update
	Reimburstment updateReimburstment(Reimburstment reimburstment);

	// delete
	boolean deleteReimburstment(Reimburstment reimburstment);
}
