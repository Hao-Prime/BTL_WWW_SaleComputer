package btl.salecomputers.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.AuthenticateDAO;
import btl.salecomputers.entity.Authenticate;

@Repository
public class AuthenticateDAOImpl implements AuthenticateDAO{

	@Autowired
	@Qualifier("userSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void saveAu(Authenticate au) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(au);
	}
	
	
}
