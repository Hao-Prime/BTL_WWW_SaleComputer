package btl.salecomputers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.AuthenticateDAO;
import btl.salecomputers.entity.Authenticate;
import btl.salecomputers.service.AuthenticateService;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private AuthenticateDAO auDao;

	@Override
	@Transactional("userTransactionManager")
	public void saveAu(Authenticate au) {
		auDao.saveAu(au);
	}

}
