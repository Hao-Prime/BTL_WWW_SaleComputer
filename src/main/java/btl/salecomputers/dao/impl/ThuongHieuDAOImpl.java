package btl.salecomputers.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import btl.salecomputers.dao.ThuongHieuDAO;
import btl.salecomputers.entity.ThuongHieu;

@Repository
public class ThuongHieuDAOImpl implements ThuongHieuDAO{

	@Autowired
	@Qualifier("webSessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<ThuongHieu> getThuongHieus() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ThuongHieu> theQuery = currentSession.createQuery("from ThuongHieu order by tenTH", ThuongHieu.class);
		List<ThuongHieu> thuongHieus = theQuery.getResultList();
		return thuongHieus;
		
	}

}
