package dev.patel.daos;

import java.util.Set;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;

import dev.patel.entities.Employee;
import dev.patel.entities.Reimburstment;
import dev.patel.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class ReimburstmentDAOhibernate implements ReimburstmentDAO {

	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Reimburstment createReimburstment(Reimburstment reimburstment) {
		
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(reimburstment);
		sess.getTransaction().commit();
		sess.close();
		return reimburstment;
	}

	@Override
	public List<Reimburstment> getAllReimburstments() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Reimburstment.class);
		List<Reimburstment> reimburstment = crit.list();
			
		return reimburstment;
	}

	@Override
	public Reimburstment getReimburstmentById(int id) {
		Session sess = sf.openSession();		
		Reimburstment reimburstment = sess.get(Reimburstment.class, id);		
		sess.close();
		
		return reimburstment;
		
	}

	@Override
	public Reimburstment updateReimburstment(Reimburstment reimburstment) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		sess.update(reimburstment);
		
		sess.getTransaction().commit();
		sess.close();
		
		return reimburstment;
	}

	@Override
	public boolean deleteReimburstment(Reimburstment reimburstment) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		sess.delete(reimburstment);
		
		sess.getTransaction().commit();
		sess.close();
		
		return true;
	}
/*
	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(int id) {
		
		try(Session sess = sf.openSession()){
			
			
			// HQL does not reference the table it references the fields
			String hql = "FROM Reimbursement r where r.e_id = id";
			Query q = sess.createQuery(hql);
			
			List<Reimbursement> reimbursements = q.list();
			for (Reimbursement reimbursement : reimbursements) {
				
				reimbursement.toString();
			}
			
			return reimbursements;
			
		
		
	}
*/

}// end class
