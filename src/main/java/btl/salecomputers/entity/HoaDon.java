package btl.salecomputers.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HoaDon")
public class HoaDon {

	@Id
	@Column(name = "maHD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHD;

	@Column(name = "ngayDat")
	private Date ngayDat;
	@Column(name = "ngayGiao")
	private Date ngayGiao;
	@Column(name = "ngayNhan")
	private Date ngayNhan;
	@Column(name = "diaChi")
	private String diaChi;
	@Column(name = "ghiChu")
	private String ghiChu;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "maHD")
	private List<ChiTietHoaDon> chiTietHoaDons;

	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public ChiTietHoaDon getChiTietHoaDon(int CTHDId) {
		if (chiTietHoaDons != null) {
			for (ChiTietHoaDon CTHD : chiTietHoaDons)
				if (CTHD.getMaCTHD() == CTHDId)
					return CTHD;
		}
		return null;
	}

	@Override
	public String toString() {
		return "HoaDon []";
	}

}
