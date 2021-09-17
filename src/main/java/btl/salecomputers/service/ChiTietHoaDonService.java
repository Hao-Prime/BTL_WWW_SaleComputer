package btl.salecomputers.service;

import btl.salecomputers.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public void saveChiTietHoaDon(ChiTietHoaDon cthd);

	public ChiTietHoaDon getCTHDById(int maCTHD);

	public void deleteChiTietHoaDon(int maCTHD);

}
