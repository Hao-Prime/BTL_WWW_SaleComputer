package btl.salecomputers.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {

	@Id
	@Column(name = "maCTHD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCTHD;

	@Column(name = "soLuong")
	private int soLuong;
	@Column(name = "ngayThem")
	private Date ngayThem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHD")
	private HoaDon hoaDon;

	@ManyToOne
	@JoinColumn(name = "maMT")
	private MayTinh mayTinh;

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public MayTinh getMayTinh() {
		return mayTinh;
	}

	public void setMayTinh(MayTinh mayTinh) {
		this.mayTinh = mayTinh;
	}

	public int getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(int maCTHD) {
		this.maCTHD = maCTHD;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayThem() {
		return ngayThem;
	}

	public void setNgayThem(Date ngayThem) {
		this.ngayThem = ngayThem;
	}

}
