package dev.patel.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import dev.patel.entities.Employee;
import dev.patel.entities.Manager;
import dev.patel.utils.HibernateUtil;

public class ManagerDAOhibernate implements ManagerDAO {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	

	@Override
	public Manager getManagerById(int id) {
		Session sess = sf.openSession();

		Manager manager = sess.get(Manager.class, id);
		sess.close();
		return manager;
	}
	
	@Override
	public List<Manager> getAllManagers() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Manager.class);
		List<Manager> manager = crit.list();

		return manager;
	}
}
