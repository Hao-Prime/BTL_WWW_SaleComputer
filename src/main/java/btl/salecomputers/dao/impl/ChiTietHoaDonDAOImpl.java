package btl.salecomputers.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.ChiTietHoaDonDAO;
import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.KhachHang;

@Repository
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {

	@Autowired
	@Qualifier("webSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void saveChiTietHoaDon(ChiTietHoaDon cthd) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(cthd);
	}

	@Override
	public ChiTietHoaDon getCTHDById(int maCTHD) {
		Session currentSession = sessionFactory.getCurrentSession();

		ChiTietHoaDon cthd = currentSession.get(ChiTietHoaDon.class, maCTHD);
		return cthd;
	}

	@Override
	public void deleteChiTietHoaDon(int maCTHD) {
		Session currentSession = sessionFactory.getCurrentSession();

		ChiTietHoaDon cthd = currentSession.get(ChiTietHoaDon.class, maCTHD);
		currentSession.delete(cthd);
		
	}

}
