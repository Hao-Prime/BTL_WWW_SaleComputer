package btl.salecomputers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.KhachHangDAO;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;
import btl.salecomputers.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangDAO khachHangDAO;

	@Override
	@Transactional("webTransactionManager")
	public List<KhachHang> getKhachHangs() {

		return khachHangDAO.getKhachHangs();
	}

	@Override
	@Transactional("webTransactionManager")
	public void saveKhachHang(KhachHang khachHang) {
		khachHangDAO.saveKhachHang(khachHang);
	}

	@Override
	@Transactional("webTransactionManager")
	public void deleteKhachHang(int maKH) {
		khachHangDAO.deleteKhachHang(maKH);
	}

	@Override
	@Transactional("webTransactionManager")
	public KhachHang getKhachHangById(int maKH) {
		return khachHangDAO.getKhachHangById(maKH);
	}

	@Override
	@Transactional("webTransactionManager")
	public List<HoaDon> getHoaDons(int maKH) {
		return khachHangDAO.getHoaDons(maKH);
	}

	@Override
	@Transactional("webTransactionManager")
	public List<KhachHang> searchKhachHang(String strFind) {
		return khachHangDAO.searchKhachHang(strFind);
	}

	@Override
	@Transactional("webTransactionManager")
	public KhachHang getKhachHangByEmail(String email) {
		return khachHangDAO.getKhachHangByEmail(email);
	}

}
