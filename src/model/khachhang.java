package model;

public class khachhang {
	private int maKH;
	private String tenKH;
	private int namSinh;
	private int sdt;
	
	public khachhang() {
		super();
	}
	
	public khachhang(int maKH, String tenKH, int namSinh, int sdt) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.namSinh = namSinh;
		this.sdt = sdt;
	}

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

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
	
	
}
