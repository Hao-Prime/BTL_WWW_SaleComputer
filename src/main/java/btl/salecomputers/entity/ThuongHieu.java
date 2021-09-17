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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ThuongHieu")
public class ThuongHieu {
	
	@Id
	@Column(name = "maTH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTH;
	
	@Column(name = "tenTH")
	private String tenTH;
	@Column(name = "moTa")
	private String moTa;
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "maTH")
	private List<MayTinh> mayTinhs;


	public int getMaTH() {
		return maTH;
	}


	public void setMaTH(int maTH) {
		this.maTH = maTH;
	}


	public String getTenTH() {
		return tenTH;
	}


	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public List<MayTinh> getMayTinhs() {
		return mayTinhs;
	}


	public void setMayTinhs(List<MayTinh> mayTinhs) {
		this.mayTinhs = mayTinhs;
	}

	public MayTinh getMayTinh(int mayTinhId) {
		if (mayTinhs != null) {
			for (MayTinh mayTinh : mayTinhs)
				if (mayTinh.getMaMT() == mayTinhId)
					return mayTinh;
		}
		return null;
	}
	
}
