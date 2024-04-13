package model;

public class hoadon {
	private int maHD;
	private String tenPhim;
	private int soBong;
	private int soNuoc;
	private int soVe;
	private int tongTien;
	private String viTriGhe;
	private String tenRap;
	
	public hoadon() {
		
	}
	
	public hoadon(int maHD, String tenPhim, int soBong, int soNuoc, int soVe, int tongTien, String viTriGhe,
			String tenRap) {
		this.maHD = maHD;
		this.tenPhim = tenPhim;
		this.soBong = soBong;
		this.soNuoc = soNuoc;
		this.soVe = soVe;
		this.tongTien = tongTien;
		this.viTriGhe = viTriGhe;
		this.tenRap = tenRap;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public int getSoBong() {
		return soBong;
	}

	public void setSoBong(int soBong) {
		this.soBong = soBong;
	}

	public int getSoNuoc() {
		return soNuoc;
	}

	public void setSoNuoc(int soNuoc) {
		this.soNuoc = soNuoc;
	}

	public int getSoVe() {
		return soVe;
	}

	public void setSoVe(int soVe) {
		this.soVe = soVe;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getViTriGhe() {
		return viTriGhe;
	}

	public void setViTriGhe(String viTriGhe) {
		this.viTriGhe = viTriGhe;
	}

	public String getTenRap() {
		return tenRap;
	}

	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}
	
	
	
}
