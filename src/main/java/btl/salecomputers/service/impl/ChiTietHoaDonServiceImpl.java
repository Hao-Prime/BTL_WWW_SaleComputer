package btl.salecomputers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.ChiTietHoaDonDAO;
import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.service.ChiTietHoaDonService;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService{

	@Autowired
	private ChiTietHoaDonDAO cthdDao;
	
	@Override
	@Transactional("webTransactionManager")
	public void saveChiTietHoaDon(ChiTietHoaDon cthd) {
		cthdDao.saveChiTietHoaDon(cthd);
	}

	@Override
	@Transactional("webTransactionManager")
	public ChiTietHoaDon getCTHDById(int maCTHD) {
		
		return cthdDao.getCTHDById(maCTHD);
	}

	@Override
	@Transactional("webTransactionManager")
	public void deleteChiTietHoaDon(int maCTHD) {
		cthdDao.deleteChiTietHoaDon(maCTHD);
	}

}
