package btl.salecomputers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.HoaDonDAO;
import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	private HoaDonDAO hoaDonDAO;

	@Override
	@Transactional("webTransactionManager")
	public HoaDon getHoaDonById(int maHD) {
		return hoaDonDAO.getHoaDonById(maHD);
	}

	@Override
	@Transactional("webTransactionManager")
	public List<ChiTietHoaDon> getChiTietHoaDon(int maHD) {
		return hoaDonDAO.getChiTietHoaDon(maHD);
	}

	@Override
	@Transactional("webTransactionManager")
	public void saveHoaDon(HoaDon hoaDon) {
		hoaDonDAO.saveHoaDon(hoaDon);

	}

	@Override
	@Transactional("webTransactionManager")
	public List<HoaDon> getHoaDonByMaKH(int maKH) {

		return hoaDonDAO.getHoaDonByMaKH(maKH);
	}

}
