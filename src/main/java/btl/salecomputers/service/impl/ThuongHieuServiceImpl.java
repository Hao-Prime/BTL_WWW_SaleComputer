package btl.salecomputers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btl.salecomputers.dao.ThuongHieuDAO;
import btl.salecomputers.entity.ThuongHieu;
import btl.salecomputers.service.ThuongHieuService;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService{
	
	@Autowired
	private ThuongHieuDAO thuongHieuDAO;
	
	
	@Override
	@Transactional("webTransactionManager")
	public List<ThuongHieu> getThuongHieus() {
		return thuongHieuDAO.getThuongHieus();
	}

}
