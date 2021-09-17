package btl.salecomputers.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.UserDAO;
import btl.salecomputers.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	@Qualifier("userSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(user);

	}

}
