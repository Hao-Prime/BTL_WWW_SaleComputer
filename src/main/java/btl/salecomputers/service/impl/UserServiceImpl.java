package btl.salecomputers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.UserDAO;
import btl.salecomputers.entity.User;
import btl.salecomputers.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional("userTransactionManager")
	public void saveUser(User user) {
		userDAO.saveUser(user);

	}

}
