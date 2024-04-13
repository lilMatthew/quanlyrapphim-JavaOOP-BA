package model;

public class nhanvien extends nguoidung {
	private int maNV;
	private String tenNV;
	private String chucVu;
	private int ngaySinh;
	private int thangSinh;
	private int namSinh;
	
	public nhanvien() {
		super();
	}
	
	public nhanvien(String tenDangNhap, String matKhau, int maNV, String tenNV, String chucVu, int ngaySinh,
			int thangSinh, int namSinh) {
		super(tenDangNhap, matKhau);
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.ngaySinh = ngaySinh;
		this.thangSinh = thangSinh;
		this.namSinh = namSinh;
	}


	public int getMaNV() {
		return maNV;
	}


	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}


	public String getTenNV() {
		return tenNV;
	}


	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}


	public String getChucVu() {
		return chucVu;
	}


	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}


	public int getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(int ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public int getThangSinh() {
		return thangSinh;
	}


	public void setThangSinh(int thangSinh) {
		this.thangSinh = thangSinh;
	}


	public int getNamSinh() {
		return namSinh;
	}


	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	
	
	
}
