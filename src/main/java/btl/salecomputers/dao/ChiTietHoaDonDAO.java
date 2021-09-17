package btl.salecomputers.dao;

import java.util.List;

import btl.salecomputers.entity.ChiTietHoaDon;

public interface ChiTietHoaDonDAO {
	public void saveChiTietHoaDon(ChiTietHoaDon cthd);
	public ChiTietHoaDon getCTHDById(int maCTHD);
	public void deleteChiTietHoaDon(int maCTHD);
}