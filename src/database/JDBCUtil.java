package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import model.hoadon;
import model.khachhang;
import model.nguoidung;
import model.nhanvien;
import model.phim;
import model.rap;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			//đăng ký MySql Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//Các thông số
			String url = "jdbc:mySQL://localhost:3306/qlyrapphim";
			String username = "root";
			String password = "12345678";
			
			//Tạo kết nối
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<nguoidung>getNguoiDung(){
		List<nguoidung>nguoidungList = new ArrayList<>();
		String query = "select * from nguoidung";
		
		try {
			Connection connection = null;
			PreparedStatement statement = null;
			
			Statement st = connection.prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				nguoidung nd = new nguoidung(rs.getString("tendangnhap"), rs.getString("matkhau"));
				nguoidungList.add(nd);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nguoidungList;
		
	}
	public static void insert(nguoidung nd) {
		String query = "insert into nguoidung(tendangnhap, matkhau "+"values(?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, nd.getTenDangNhap());
			ppstm.setString(2, nd.getMatKhau());
			ppstm.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(nguoidung nd) {
		String query = " delete from nguoidung "+"where tendangnhap = '"+nd.getTenDangNhap()+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(nguoidung nd) {
		String query = " update nguoidung "+" set matkhau = ?"+" where tennguoidung = '"+ nd.getTenDangNhap()+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, nd.getMatKhau());
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static nguoidung login(String tennguoidung, String matkhau) {
		nguoidung nguoidung = new nguoidung(tennguoidung, matkhau);
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from nguoidung "+" where tenguoidung = ? and matkhau = ?";
			Statement st = connection.prepareStatement(sql);
			PreparedStatement ppstm = connection.prepareStatement(sql);
			ppstm.setString(1, tennguoidung);
			ppstm.setString(2, matkhau);
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				nguoidung nd = new nguoidung(rs.getString("tendangnhap"), rs.getString("matkhau"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nguoidung;
	}
	public static List<hoadon>findAll(){
		List<hoadon>hoadonList = new ArrayList<>();
		Connection connection = JDBCUtil.getConnection();
		String query = " select * from hoadon ";
		
		try {
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				hoadon hd = new hoadon(rs.getInt("maHD"), rs.getNString("tenPhim"), rs.getInt("sobong"), rs.getInt("sonuoc"), rs.getInt("sove"), rs.getInt("tongtien"), rs.getString("vitrighe"), rs.getString("tenRap"));
				hoadonList.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hoadonList;
	}
	public static void insert(hoadon hd) {
		String query = "insert into hoadon(mahoadon, tenphim, sobong, sonuoc, sove, tongtien, vitrighe, tenrap)"+"values(?,?,?,?,?,?,?,?);";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setInt(1, hd.getMaHD());
			ppstm.setString(2, hd.getTenPhim());
			ppstm.setInt(3, hd.getSoBong());
			ppstm.setInt(4, hd.getSoNuoc());
			ppstm.setInt(5, hd.getSoVe());
			ppstm.setInt(6, hd.getTongTien());
			ppstm.setString(7, hd.getViTriGhe());
			ppstm.setString(8, hd.getTenRap());
			ppstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(hoadon hd) {
		String query = " delete from hoadon"+" where mahoadon = '"+hd.getMaHD()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(hoadon hd) {
		String query = "update hoadon"+"set tenphim = ?, sobong = ?, soNuoc = ?, sove = ?,"+"tongtien = ?, vitrighe = ?, tenrap = ?"+"where mahoadon = '"+hd.getMaHD()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, hd.getTenPhim());
			ppstm.setInt(2, hd.getSoBong());
			ppstm.setInt(3, hd.getSoNuoc());
			ppstm.setInt(4, hd.getSoVe());
			ppstm.setInt(5, hd.getTongTien());
			ppstm.setString(6, hd.getViTriGhe());
			ppstm.setString(7, hd.getTenRap());
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<hoadon>findBymahoadon(hoadon hd){
		List<hoadon>hoadonL = new ArrayList<>();
		String query = "select * from hoadon"+"where mahoa = '"+hd.getMaHD()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				hoadon hdl = new hoadon(rs.getInt("mahoadon"), rs.getString("tenphim"), rs.getInt("sobong"), rs.getInt("sonuoc"), rs.getInt("sove"), rs.getInt("tongtien"), rs.getString("vitrighe"), rs.getString("tenrap"));
				hoadonL.add(hdl);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hoadonL;
	}
	public static List<khachhang>findAll1(){
		List<khachhang>khachhangList = new ArrayList<>();
		String query = "select * from khachhang";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				khachhang kh = new khachhang(rs.getInt("makhachhang"), rs.getString("tenkhachhang"), rs.getInt("namsinh"), rs.getInt("sdt"));
				khachhangList.add(kh);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return khachhangList;
	}
	public static void insert1(khachhang kh) {
		String query ="insert into khachhang(makhachhang, tenkhachhang, namsinh, sdt)"+"values(?,?,?,?)";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setInt(1, kh.getMaKH());
			ppstm.setString(2, kh.getTenKH());
			ppstm.setInt(3, kh.getNamSinh());
			ppstm.setInt(4, kh.getSdt());
			ppstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(khachhang kh) {
		String query = "delete from khachhang"+"where makhachhang = '"+kh.getMaKH()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(khachhang kh) {
		String query = "update khachhang"+"set tenkhachhang = ?, namsinh = ?, sdt = ?"+"where makhachhang = '"+kh.getMaKH()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, kh.getTenKH());
			ppstm.setInt(2, kh.getNamSinh());
			ppstm.setInt(3, kh.getSdt());
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<khachhang>findBymakhachhang(khachhang k){
		List<khachhang>khachhangL = new ArrayList<>();
		String query = "select * from khachhang"+"where makhachhang = '"+k.getMaKH()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				khachhang kh = new khachhang(rs.getInt("makhachhang"), rs.getString("tenkhachhang"), rs.getInt("namsinh"), rs.getInt("sdt"));
				khachhangL.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return khachhangL;
	}
	public static List<phim>findAll2(){
		List<phim>phimList = new ArrayList<>();
		String query = " select * from phim ";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				phim p = new phim(rs.getString("tenphim"), rs.getInt("ngaychieu"), rs.getInt("thangchieu"), rs.getInt("namchieu"), rs.getString("hangsanxuat"), rs.getString("trangthai"));
				phimList.add(p);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return phimList;
	}
	public static void insert(phim p) {
		String query = "insert into phim(tenphim, ngaychieu, thangchieu, namchieu, hangsanxuat, trangthai)"+"values(?,?,?,?,?,?)";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, p.getTenPhim());
			ppstm.setInt(2, p.getNgayChieu());
			ppstm.setInt(3, p.getThangChieu());
			ppstm.setInt(4, p.getNamChieu());
			ppstm.setString(5, p.getHangSX());
			ppstm.setString(6, p.getTrangThai());
			ppstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(phim p) {
		String query = "delete from phim"+"where tenphim = '"+p.getTenPhim()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setInt(1, p.getNgayChieu());
			ppstm.setInt(2, p.getThangChieu());
			ppstm.setInt(3, p.getNamChieu());
			ppstm.setString(4, p.getHangSX());
			ppstm.setString(5, p.getTrangThai());
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(phim p) {
		String query = "update phim "+" set ngaychieu = ?, thangchieu = ?, namchieu = ?, hangsanxuat = ?, trangthai = ? "+"where tenphim = '"+p.getTenPhim()+"';";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setInt(1, p.getNgayChieu());
			ppstm.setInt(2, p.getThangChieu()) ;
			ppstm.setInt(3, p.getNamChieu()) ;
			ppstm.setString(4, p.getHangSX()) ; 
			ppstm.setString(5, p.getTrangThai());
			ppstm.executeUpdate() ; 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<phim>findBytenphim(phim p1){
		List<phim>phimL = new ArrayList<>();
		String query = "select * from phim "+"where tenphim = '"+p1.getTenPhim()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				phim p = new phim(rs.getString("tenphim"), rs.getInt("ngaychieu"), rs.getInt("thangchieu"), rs.getInt("namchieu"), rs.getString("hangsanxuat"), rs.getString("trangthai"));
				phimL.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return phimL;
	}
	public static List<rap>getrap(){
		List<rap>rapList = new ArrayList<>();
		String query = " select * from rap ";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				rap r = new rap(rs.getString("tenrap"), rs.getInt("socho"));
				rapList.add(r);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rapList;
	}
	public static void insert(rap r) {
		String query = "insert into rap(tenrap, socho)"+"values(?,?)";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, r.getTenRap());
			ppstm.setInt(2, r.getSoCho());
			ppstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(rap r) {
		String query = " delete from rap "+" where tenrap = '"+r.getTenRap()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(rap r) {
		String query = " update rap "+"set socho = ?"+"where tenrap = '"+r.getTenRap()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setInt(1, r.getSoCho());
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<rap>getBytenrap(rap r){
		List<rap>rapL = new ArrayList<>();
		String query = " select * from rap "+" where tenrap = '"+r.getTenRap()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				rap p = new rap(rs.getString("tenrap"), rs.getInt("socho"));
				rapL.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rapL;
	}
	public static List<nhanvien>getnhanvien(){
		List<nhanvien>nhanvienList = new ArrayList<>();
		String query = " select * from nhanvien";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				nhanvien n = new nhanvien(rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getInt("manhanvien"), rs.getString("tennhanvien"), rs.getString("chucvu"), rs.getInt("ngaysinh"), rs.getInt("thangsinh"), rs.getInt("namsinh"));
				nhanvienList.add(n);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienList;
	}
	public static void insert(nhanvien n) {
		String query = "insert into nhanvien(manhanvien, tennhanvien, chucvu, ngaysinh, thangsinh, namsinh)"+"values(?,?,?,?,?,?)";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, n.getTenDangNhap());
			ppstm.setString(2, n.getMatKhau());
			ppstm.setInt(3, n.getMaNV());
			ppstm.setString(4, n.getTenNV());
			ppstm.setString(5, n.getChucVu());
			ppstm.setInt(6, n.getNgaySinh());
			ppstm.setInt(7, n.getThangSinh());
			ppstm.setInt(8, n.getNamSinh());
			ppstm.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(nhanvien n) {
		String query = " delete from nhanvien "+"where manhanvien = '"+ n.getMaNV()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(nhanvien n) {
		String query = " update nhanvien "+" set tenhanvien = ?, chucvu = ?, ngaysinh = ?, thangsinh = ?, namsinh = ?"+" where manhanvien = '"+n.getMaNV()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ppstm.setString(1, n.getTenDangNhap());
			ppstm.setString(2, n.getMatKhau());
			ppstm.setInt(3, n.getMaNV());
			ppstm.setString(4, n.getTenNV());
			ppstm.setString(5, n.getChucVu());
			ppstm.setInt(6, n.getNgaySinh());
			ppstm.setInt(7, n.getThangSinh());
			ppstm.setInt(8, n.getNamSinh());
			ppstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<nhanvien>getBymanhanvien(nhanvien n){
		List<nhanvien>nhanvienL = new ArrayList<>();
		String query = " select * from nhanvien "+"where manhanvien = '"+n.getMaNV()+"'";
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement ppstm = connection.prepareStatement(query);
			ResultSet rs = ppstm.executeQuery(query);
			while(rs.next()) {
				nhanvien n1 = new nhanvien(rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getInt("manhanvien"), rs.getString("tennhanvien"), rs.getString("chucvu"), rs.getInt("ngaysinh"), rs.getInt("thangsinh"), rs.getInt("namsinh"));
				nhanvienL.add(n1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienL;
	}
}
