package model;

public class phim {
	private String tenPhim;
	private int ngayChieu;
	private int thangChieu;
	private int namChieu;
	private String hangSX;
	private String trangThai;
	
	public phim() {
		
	}
	
	
	public phim(String tenPhim, int ngayChieu, int thangChieu, int namChieu, String hangSX, String trangThai) {
		this.tenPhim = tenPhim;
		this.ngayChieu = ngayChieu;
		this.thangChieu = thangChieu;
		this.namChieu = namChieu;
		this.hangSX = hangSX;
		this.trangThai = trangThai;
	}


	public String getTenPhim() {
		return tenPhim;
	}


	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}


	public int getNgayChieu() {
		return ngayChieu;
	}


	public void setNgayChieu(int ngayChieu) {
		this.ngayChieu = ngayChieu;
	}


	public int getThangChieu() {
		return thangChieu;
	}


	public void setThangChieu(int thangChieu) {
		this.thangChieu = thangChieu;
	}


	public int getNamChieu() {
		return namChieu;
	}


	public void setNamChieu(int namChieu) {
		this.namChieu = namChieu;
	}


	public String getHangSX() {
		return hangSX;
	}


	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	
}
