package btl.salecomputers.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class KhachHang {

	@Id
	@Column(name = "maKH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKH;

	@Column(name = "tenKH")
	private String tenKH;
	@Column(name = "email")
	private String email;
	@Column(name = "soDT")
	private String soDT;
	@Column(name = "soCMND")
	private String soCMND;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "maKH")
	private List<HoaDon> hoaDons;

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public List<HoaDon> getHoaDons() {
		List<HoaDon> list = new ArrayList<>();
		for (HoaDon hoaDon : hoaDons) {
			if (!list.contains(hoaDon))
				list.add(hoaDon);
		}
		return list;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public HoaDon getHoaDon(int hoaDonId) {
		if (hoaDons != null) {
			for (HoaDon hoaDon : hoaDons)
				if (hoaDon.getMaHD() == hoaDonId)
					return hoaDon;
		}
		return null;
	}

}
