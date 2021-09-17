package btl.salecomputers.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.MayTinhDAO;
import btl.salecomputers.entity.MayTinh;

@Repository
public class MayTinhDAOImpl implements MayTinhDAO{
	@Autowired
	@Qualifier("webSessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public List<MayTinh> getMayTinhs(String sort) {
		Session currentSession = sessionFactory.getCurrentSession();
		if (sort != null) {
			if (sort.equals("giatang")) {
				sort = "from MayTinh order by gia ASC";
			} else if (sort.equals("giagiam")) {
				sort = "from MayTinh order by gia DESC";
			} else if (sort.equals("ramtang")) {
				sort = "from MayTinh order by ramMT ASC";
			} else if (sort.equals("ramgiam")) {
				sort = "from MayTinh order by ramMT DESC";
			} else
				sort = "from MayTinh where maTH = "+sort;
		}
		
		else
			sort = "from MayTinh order by maMT DESC";

		
		Query<MayTinh> theQuery = currentSession.createQuery(sort, MayTinh.class);
		List<MayTinh> mayTinhs = theQuery.getResultList();
		return mayTinhs;
	}

	@Override
	public void saveMayTinh(MayTinh theMayTinh) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theMayTinh);
		
//		Query query = currentSession.createQuery(
//				"INSERT INTO MayTinh (tenMT, moTa, hinhAnh) values (:tenMT,:moTa, :hinhAnh)");
//		query.setParameter("maMT",theMayTinh.getTenMT());
//		query.setParameter("moTa",theMayTinh.getMoTa());
//		query.setParameter("hinhAnh",inputStream);
//		query.executeUpdate();
		
	}

	@Override
	public MayTinh getMayTinh(int maMT) {
		Session currentSession = sessionFactory.getCurrentSession();
		MayTinh theMayTinh = currentSession.get(MayTinh.class, maMT);
		return theMayTinh;
	}

	@Override
	public void deleteMayTinh(int maMT) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		MayTinh theMayTinh = currentSession.get(MayTinh.class, maMT);
		currentSession.delete(theMayTinh);

	}
	@Override
	public List<MayTinh> searchMayTinhByName(String theSearchName) {
		List<MayTinh> mt = null;
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			Session session = sessionFactory.openSession();

			Query query = session.createQuery(
					"from MayTinh where lower(tenMT) like :theName or lower(tenMT) like :theName",
					MayTinh.class);
			query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
			mt = query.getResultList();
		} else
			mt = getMayTinhs(null);

		return mt;
	}
		
		
	

}
