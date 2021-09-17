package btl.salecomputers.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.KhachHangDAO;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;

@Repository
public class KhachHangDAOImpl implements KhachHangDAO {

	@Autowired
	@Qualifier("webSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<KhachHang> getKhachHangs() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang", KhachHang.class);
		// execute query and get result list
		List<KhachHang> khachHangs = theQuery.getResultList();
		return khachHangs;
	}

	@Override
	public KhachHang getKhachHangById(int maKH) {
		Session currentSession = sessionFactory.getCurrentSession();

		KhachHang kh = currentSession.get(KhachHang.class, maKH);
		return kh;
	}

	@Override
	public void saveKhachHang(KhachHang khachHang) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(khachHang);

	}

	@Override
	public void deleteKhachHang(int maKH) {
		Session currentSession = sessionFactory.getCurrentSession();

		KhachHang kh = currentSession.get(KhachHang.class, maKH);
		currentSession.delete(kh);
	}

	@Override
	public List<HoaDon> getHoaDons(int maKH) {
		KhachHang kh = getKhachHangById(maKH);
		List<HoaDon> listHoaDons = kh.getHoaDons();
		return listHoaDons;

	}

	@Override
	public List<KhachHang> searchKhachHang(String strFind) {
		List<KhachHang> khachHangs = null;
		if (strFind != null && strFind.trim().length() > 0) {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from KhachHang where lower(tenKH) like :find", KhachHang.class);
			query.setParameter("find", "%" + strFind.toLowerCase() + "%");
			khachHangs = query.getResultList();
		} else
			khachHangs = getKhachHangs();
		return khachHangs;
	}

	@Override
	public KhachHang getKhachHangByEmail(String email) {
		KhachHang kh = new KhachHang();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from KhachHang where email = :email", KhachHang.class);
		query.setParameter("email", email);
		kh = (KhachHang) query.getResultList().get(0);
		return kh;
	}

}
