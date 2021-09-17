package btl.salecomputers.entity.DTO;

public class MayTinhDTO {
	private int maMT;
	
	private String tenMT;

	private int ramMT;

	private float manHinhMT;

	private int soLuong;

	private String gia;

	private String hinhAnh;
	
	private String moTa;
	
	private String thuongHieu;
	
	
	
	
	public String getThuongHieu() {
		return thuongHieu;
	}


	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}


	public MayTinhDTO() {
	
	}


	public MayTinhDTO(int maMT, String tenMT, int ramMT, float manHinhMT, int soLuong, String gia, String hinhAnh,
			String moTa,String thuongHieu) {
		
		this.maMT = maMT;
		this.tenMT = tenMT;
		this.ramMT = ramMT;
		this.manHinhMT = manHinhMT;
		this.soLuong = soLuong;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
		this.thuongHieu = thuongHieu;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
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


	public String getGia() {
		return gia;
	}


	public void setGia(String gia) {
		this.gia = gia;
	}



	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}



	


}
