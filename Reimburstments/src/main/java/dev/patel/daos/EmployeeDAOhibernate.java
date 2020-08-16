package dev.patel.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import dev.patel.entities.Employee;
import dev.patel.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class EmployeeDAOhibernate implements EmployeeDAO {
	
	

	// session factory creates sessions
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	// Methods
	@Override
	public Employee createEmployee(Employee employee) {
		// session is the primary interface for performing CRUD operations in Hibernate
		Session sess = sf.openSession(); // open a session
		sess.beginTransaction(); // begin a transaction

		sess.save(employee); // this will save our employee object

		sess.getTransaction().commit(); // commit the transaction
		sess.close(); // close a session

		return employee;
	}

	// @Override
	public Employee getEmployeeById(int id) {
		Session sess = sf.openSession();

		Employee employee = sess.get(Employee.class, id);
		sess.close();
		return employee;

	}

	@Override
	public List<Employee> getAllEmployees() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Employee.class);
		List<Employee> employee = crit.list();

		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session sess = sf.openSession();
		sess.beginTransaction();

		sess.update(employee);

		sess.getTransaction().commit();
		sess.close();

		return employee;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		Session sess = sf.openSession();
		sess.beginTransaction();

		sess.delete(employee);

		sess.getTransaction().commit();
		sess.close();

		return true;
	}

	

}
