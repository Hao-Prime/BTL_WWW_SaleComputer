package btl.salecomputers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.MayTinhDAO;
import btl.salecomputers.entity.MayTinh;
import btl.salecomputers.service.MayTinhService;


@Service
public class MayTinhServiceImpl implements MayTinhService{

	@Autowired
	private MayTinhDAO mayTinhDAO;
	
	
	
	@Override
	@Transactional("webTransactionManager")
	public List<MayTinh> getMayTinhs(String sort) {
		return mayTinhDAO.getMayTinhs(sort);
	}

	@Override
	@Transactional("webTransactionManager")
	public void saveMayTinh(MayTinh theMayTinh) {
		mayTinhDAO.saveMayTinh(theMayTinh);
		
	}

	@Override
	@Transactional("webTransactionManager")
	public MayTinh getMayTinh(int maMT) {
		return mayTinhDAO.getMayTinh(maMT);
	}

	@Override
	@Transactional("webTransactionManager")
	public void deleteMayTinh(int maMT) {
		mayTinhDAO.deleteMayTinh(maMT);
		
	}

	@Override
	@Transactional("webTransactionManager")
	public List<MayTinh> searchMayTinhByName(String theSearchName) {
		return mayTinhDAO.searchMayTinhByName(theSearchName);
	}

}
