package btl.salecomputers.service;

import java.util.List;

import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;

public interface KhachHangService {
	public List<KhachHang> getKhachHangs();
	public void saveKhachHang(KhachHang khachHang);
	public void deleteKhachHang(int maKH);
	public KhachHang getKhachHangById(int maKH);
	public List<HoaDon> getHoaDons(int maKH);
	public List<KhachHang> searchKhachHang(String strFind);
	public KhachHang getKhachHangByEmail(String email);
}
