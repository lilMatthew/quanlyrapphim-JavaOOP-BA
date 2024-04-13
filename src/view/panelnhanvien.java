package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import database.JDBCUtil;
import model.khachhang;
import model.nhanvien;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class panelnhanvien extends JPanel {
	private JTable table;
	private JTextField txtmanhanvien;
	private JTextField txttennhanvien;
	private JTextField txtchucvu;
	private JDateChooser dcngaysinh ;
	/**
	 * Create the panel.
	 */
	public panelnhanvien() {
		Connection connection = JDBCUtil.getConnection() ; 
		setBounds(134, 11, 870, 557);
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JComboBox cbngaysinh = new JComboBox();
		cbngaysinh.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		cbngaysinh.setBounds(96, 401, 143, 22);
		add(cbngaysinh);
		
		JComboBox cbthangsinh = new JComboBox();
		cbthangsinh.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbthangsinh.setBounds(96, 450, 143, 22);
		add(cbthangsinh);
		
		JComboBox cbnamsinh = new JComboBox();
		cbnamsinh.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		cbnamsinh.setBounds(95, 499, 143, 22);
		add(cbnamsinh);
		
		JButton btnnhap = new JButton("Nhập");
		btnnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					nhanvien n = new nhanvien() ; 
					n.setMaNV(Integer.parseInt(txtmanhanvien.getText()));
					n.setTenNV(txttennhanvien.getText());
					n.setNgaySinh(Integer.parseInt(cbngaysinh.getSelectedItem().toString())); 
					n.setThangSinh(Integer.parseInt(cbthangsinh.getSelectedItem().toString())); 
					n.setNamSinh(Integer.parseInt(cbnamsinh.getSelectedItem().toString())); 
					n.setChucVu(txtchucvu.getText());	
					JOptionPane.showMessageDialog(null, " nhập nhân viên thành công ! ");
					DefaultTableModel model = (DefaultTableModel) table.getModel() ; 
					model.addRow(
							new Object[] { 
									n.getMaNV()+"" ,
									n.getTenNV(),
									n.getNgaySinh()+"",
									n.getThangSinh()+"",
									n.getNamSinh()+"",
									n.getChucVu(),
							});
					JDBCUtil.insert(n);   
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnnhap.setBackground(new Color(255, 255, 255));
		btnnhap.setBounds(771, 11, 89, 88);
		add(btnnhap);
		
		JButton btncapnhat = new JButton("Cập nhật");
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					nhanvien n = new nhanvien() ; 
					n.setMaNV(Integer.parseInt(txtmanhanvien.getText()));
					n.setTenNV(txttennhanvien.getText());
					n.setChucVu(txtchucvu.getText());	
					n.setNgaySinh(Integer.parseInt(cbngaysinh.getSelectedItem().toString())); 
					n.setThangSinh(Integer.parseInt(cbthangsinh.getSelectedItem().toString())); 
					n.setNamSinh(Integer.parseInt(cbnamsinh.getSelectedItem().toString())); 			
					JDBCUtil.update(n);; 
					JOptionPane.showMessageDialog(null, " Cập nhật nhân viên thành công ! ");
					shownhanvien(JDBCUtil.getnhanvien()) ;
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btncapnhat.setBackground(new Color(255, 255, 255));
		btncapnhat.setBounds(771, 123, 89, 88);
		add(btncapnhat);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien n =new nhanvien() ; 
				n.setMaNV(Integer.parseInt(txtmanhanvien.getText())); 
				JOptionPane.showMessageDialog(null, " Xóa nhân viên thành công ! ");
				JDBCUtil.delete(n);; 
				shownhanvien(JDBCUtil.getnhanvien()) ; 
			}
		});
		btnxoa.setBackground(new Color(255, 255, 255));
		btnxoa.setBounds(771, 237, 89, 88);
		add(btnxoa);
		
		JButton btnlammoi = new JButton("Làm mới ");
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmanhanvien.setText("");
				txttennhanvien.setText("");	
				cbngaysinh.setSelectedItem("");
				cbthangsinh.setSelectedItem("");
				cbnamsinh.setSelectedItem("");
				txtchucvu.setText("");
			}
		});
		btnlammoi.setBackground(new Color(255, 255, 255));
		btnlammoi.setBounds(771, 353, 89, 88);
		add(btnlammoi);
		
		JButton btntimkiem = new JButton("Tìm kiếm ");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien n = new nhanvien() ; 
				n.setMaNV(Integer.parseInt(txtmanhanvien.getText()));
				JDBCUtil.getBymanhanvien(n) ; 
				shownhanvien(JDBCUtil.getBymanhanvien(n));
			}
		});
		btntimkiem.setBackground(new Color(255, 255, 255));
		btntimkiem.setForeground(new Color(0, 0, 0));
		btntimkiem.setBounds(771, 458, 89, 88);
		add(btntimkiem);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(739, 11, 23, 535);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 11, 401, 535);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn ", "T\u00EAn nh\u00E2n vi\u00EAn", "ng\u00E0y sinh", "Th\u00E1ng sinh", "N\u0103m sinh", "Ch\u1EE9c v\u1EE5"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		scrollPane.setViewportView(table);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(316, 11, 31, 535);
		add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setBounds(10, 40, 89, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1.setBounds(10, 180, 89, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày sinh");
		lblNewLabel_2.setBounds(10, 397, 75, 31);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Chức vụ");
		lblNewLabel_3.setBounds(10, 294, 75, 31);
		add(lblNewLabel_3);
		
		txtmanhanvien = new JTextField();
		txtmanhanvien.setBounds(98, 40, 141, 31);
		add(txtmanhanvien);
		txtmanhanvien.setColumns(10);
		
		txttennhanvien = new JTextField();
		txttennhanvien.setColumns(10);
		txttennhanvien.setBounds(95, 180, 141, 31);
		add(txttennhanvien);
		
		txtchucvu = new JTextField();
		txtchucvu.setColumns(10);
		txtchucvu.setBounds(95, 294, 141, 31);
		add(txtchucvu);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tháng sinh");
		lblNewLabel_2_1.setBounds(10, 446, 75, 31);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày sinh");
		lblNewLabel_2_2.setBounds(10, 495, 75, 31);
		add(lblNewLabel_2_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 357, 296, 11);
		add(separator_2);
		
		
	}
	public void shownhanvien(List<nhanvien>n) { 
		Connection connection = JDBCUtil.getConnection() ; 
		List<nhanvien>Listnhanvien = new ArrayList<>() ; 
		Listnhanvien = n ;
		DefaultTableModel tableModel ; 
		table.getModel() ; 
		tableModel = (DefaultTableModel)table.getModel() ; 
		tableModel.setRowCount(0);
		Listnhanvien.forEach((nhanvien) -> { 
			tableModel.addRow(new Object[] { 
				nhanvien.getMaNV(),nhanvien.getTenNV(),
				nhanvien.getNgaySinh(),nhanvien.getThangSinh(),
				nhanvien.getNamSinh(),nhanvien.getChucVu()
				});
			}); 
		}
}
