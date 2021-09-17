package btl.salecomputers.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MayTinh")
public class MayTinh {
	
	@Id
	@Column(name = "maMT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maMT;
	
	@Column(name = "tenMT")
	private String tenMT;
	@Column(name = "ramMT")
	private int ramMT;
	@Column(name = "manHinhMT")
	private float manHinhMT;
	@Column(name = "soLuong")
	private int soLuong;
	@Column(name = "gia")
	private double gia;
	
	@Column(name = "hinhAnh")
	@Lob
	private byte[] hinhAnh;
	
	
	@Column(name = "moTa")
	private String moTa;
	
	@ManyToOne
	@JoinColumn(name = "maTH")
	private ThuongHieu thuonghieu;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "maMT")
	private List<ChiTietHoaDon> chiTietHoaDons;

	

	public ThuongHieu getThuonghieu() {
		return thuonghieu;
	}


	public void setThuonghieu(ThuongHieu thuonghieu) {
		this.thuonghieu = thuonghieu;
	}


	public int getMaMT() {
		return maMT;
	}


	public void setMaMT(int maMT) {
		this.maMT = maMT;
	}


	public String getTenMT() {
		return tenMT;
	}


	public void setTenMT(String tenMT) {
		this.tenMT = tenMT;
	}


	public int getRamMT() {
		return ramMT;
	}


	public void setRamMT(int ramMT) {
		this.ramMT = ramMT;
	}


	public float getManHinhMT() {
		return manHinhMT;
	}


	public void setManHinhMT(float manHinhMT) {
		this.manHinhMT = manHinhMT;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public double getGia() {
		return gia;
	}


	public void setGia(double gia) {
		this.gia = gia;
	}


	public byte[] getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	


}
