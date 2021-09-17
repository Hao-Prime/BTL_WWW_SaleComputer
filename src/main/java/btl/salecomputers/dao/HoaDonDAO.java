package btl.salecomputers.dao;

import java.util.List;

import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.HoaDon;

public interface HoaDonDAO {
	public HoaDon getHoaDonById(int maHD);
	public List<ChiTietHoaDon> getChiTietHoaDon(int maHD);
	public void saveHoaDon(HoaDon hoaDon);
	public List<HoaDon> getHoaDonByMaKH(int maKH);
}
