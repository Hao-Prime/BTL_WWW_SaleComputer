package btl.salecomputers.dao;

import java.util.List;

import btl.salecomputers.entity.MayTinh;

public interface MayTinhDAO {
	public List<MayTinh> getMayTinhs(String sort);
	public void saveMayTinh(MayTinh theMayTinh);
	public MayTinh getMayTinh(int maMT);
	public void deleteMayTinh(int maMT);
	public List<MayTinh> searchMayTinhByName(String theSearchName);
}
