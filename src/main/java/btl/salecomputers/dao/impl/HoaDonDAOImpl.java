package btl.salecomputers.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.HoaDonDAO;
import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;

@Repository
public class HoaDonDAOImpl implements HoaDonDAO {

	@Autowired
	@Qualifier("webSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public HoaDon getHoaDonById(int maHD) {
		Session curentSession = sessionFactory.getCurrentSession();

		HoaDon hd = curentSession.get(HoaDon.class, maHD);
		return hd;
	}

	@Override
	public List<ChiTietHoaDon> getChiTietHoaDon(int maHD) {
		HoaDon hd = getHoaDonById(maHD);
		List<ChiTietHoaDon> chiTietHoaDons = hd.getChiTietHoaDons();
		return chiTietHoaDons;
	}

	@Override
	public void saveHoaDon(HoaDon hoaDon) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(hoaDon);

	}

	@Override
	public List<HoaDon> getHoaDonByMaKH(int maKH) {
		List<HoaDon> hoaDons = null;

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from HoaDon where maKH = :maKH", HoaDon.class);
		query.setParameter("maKH", maKH);
		hoaDons = query.getResultList();

		return hoaDons;
	}

}
