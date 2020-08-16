package dev.patel.daos;

import java.util.List;
import java.util.Set;

import dev.patel.entities.Employee;
import dev.patel.entities.Manager;

public interface ManagerDAO {
	
	Manager getManagerById(int id);
	//Manager getManagerByName(String name);
	
	List<Manager> getAllManagers();
	
}
