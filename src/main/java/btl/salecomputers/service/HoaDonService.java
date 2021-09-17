package btl.salecomputers.service;

import java.util.List;

import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.HoaDon;

public interface HoaDonService {
	public HoaDon getHoaDonById(int maHD);
	public List<ChiTietHoaDon> getChiTietHoaDon(int maHD);
	public void saveHoaDon(HoaDon hoaDon);
	public List<HoaDon> getHoaDonByMaKH(int maKH);
}

