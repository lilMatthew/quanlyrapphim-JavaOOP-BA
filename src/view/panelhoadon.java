package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.JDBCUtil;
import model.hoadon;

public class panelhoadon extends JPanel {
	private JTextField txtmahoadon;
	private JTextField txttenrap;
	private JTextField txtvitrighe;
	private JTextField txtsobong;
	private JTextField txtsonuoc;
	private JTextField txtsove;
	private JTextField txttongtien;
	private static JTable table;
	
	public panelhoadon() {
		Connection connection = JDBCUtil.getConnection() ; 
		setBackground(new Color(192, 192, 192));
		setForeground(new Color(64, 128, 128));
		setBounds(134, 11, 870, 557);
		setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã hóa đơn ");
		lblNewLabel_2.setBounds(10, 63, 89, 26);
		add(lblNewLabel_2);
		
		txtmahoadon = new JTextField();
		txtmahoadon.setBounds(86, 63, 101, 26);
		add(txtmahoadon);
		txtmahoadon.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tên phim");
		lblNewLabel_7.setBounds(10, 192, 64, 26);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Vị trí ghế ngồi ");
		lblNewLabel_8.setBounds(639, 63, 101, 26);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tên rạp");
		lblNewLabel_9.setBounds(639, 192, 84, 26);
		add(lblNewLabel_9);
		
		txttenrap = new JTextField();
		txttenrap.setBounds(733, 192, 101, 26);
		add(txttenrap);
		txttenrap.setColumns(10);
		
		txtvitrighe = new JTextField();
		txtvitrighe.setBounds(733, 63, 101, 26);
		add(txtvitrighe);
		txtvitrighe.setColumns(10);
		
		JLabel sobong = new JLabel("Số bỏng");
		sobong.setBounds(266, 11, 64, 26);
		add(sobong);
		
		JLabel sonuoc = new JLabel("Số nước");
		sonuoc.setBounds(266, 81, 64, 26);
		add(sonuoc);
		
		JLabel sove = new JLabel("Số vé");
		sove.setBounds(266, 159, 64, 26);
		add(sove);
		
		JLabel tongtien = new JLabel("Tổng tiền");
		tongtien.setBounds(266, 231, 64, 26);
		add(tongtien);
		
		txtsobong = new JTextField();
		txtsobong.setColumns(10);
		txtsobong.setBounds(340, 11, 101, 26);
		add(txtsobong);
		
		txtsonuoc = new JTextField();
		txtsonuoc.setColumns(10);
		txtsonuoc.setBounds(340, 81, 101, 26);
		add(txtsonuoc);
		
		txtsove = new JTextField();
		txtsove.setColumns(10);
		txtsove.setBounds(340, 159, 101, 26);
		add(txtsove);
		
		txttongtien = new JTextField();
		txttongtien.setColumns(10);
		txttongtien.setBounds(340, 231, 101, 26);
		add(txttongtien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 305, 850, 140);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "T\u00EAn phim", "S\u1ED1 b\u1ECFng", "S\u1ED1 n\u01B0\u1EDBc", "S\u1ED1 v\u00E9", "T\u1ED5ng ti\u1EC1n", "V\u1ECB tr\u00ED gh\u1EBF ng\u1ED3i", "T\u00EAn r\u1EA1p"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(69);
		table.getColumnModel().getColumn(7).setPreferredWidth(62);
		
		JComboBox cbtenphim = new JComboBox();
		cbtenphim.setModel(new DefaultComboBoxModel(new String[] {"Fast And Furious", "Lat Mat", "Doraemon", "Connan"}));
		cbtenphim.setBounds(87, 194, 140, 22);
		add(cbtenphim);
		
		JButton btnxuat = new JButton("Xuất");
		btnxuat.setBackground(new Color(255, 128, 192));
		btnxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					hoadon hd = new hoadon() ; 
					hd.setMaHD(Integer.valueOf(txtmahoadon.getText()));
					hd.setTenPhim(cbtenphim.getSelectedItem().toString());
					hd.setSoBong(Integer.parseInt(txtsobong.getText()));
					hd.setSoNuoc(Integer.parseInt(txtsonuoc.getText()));				
					hd.setSoVe(Integer.parseInt(txtsove.getText()));	
					hd.setTongTien(Integer.parseInt(txttongtien.getText()));
					hd.setViTriGhe(txtvitrighe.getText()); 
					hd.setTenRap(txttenrap.getText());
					JOptionPane.showMessageDialog(null, " Xuất hóa đơn thành công ! ");
					DefaultTableModel model = (DefaultTableModel) table.getModel() ; 
					model.addRow(
							new Object[] { 
									hd.getMaHD()+"" ,
									hd.getTenPhim(),
									hd.getSoBong()+"",
									hd.getSoNuoc()+"",
									hd.getSoVe()+"",
									hd.getTongTien()+"",
									hd.getViTriGhe(),
									hd.getTenRap(),
							});
					JDBCUtil.insert(hd) ; 
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnxuat.setBounds(10, 484, 89, 62);
		add(btnxuat);
		
		JButton btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBackground(new Color(255, 128, 192));
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					hoadon hd = new hoadon() ; 
					hd.setMaHD(Integer.parseInt(txtmahoadon.getText()));
					hd.setTenPhim(cbtenphim.getSelectedItem().toString());
					hd.setSoBong(Integer.parseInt(txtsobong.getText()));
					hd.setSoNuoc(Integer.parseInt(txtsonuoc.getText()));				
					hd.setSoVe(Integer.parseInt(txtsove.getText()));	
					hd.setTongTien(Integer.parseInt(txttongtien.getText()));
					hd.setViTriGhe(txtvitrighe.getText()); 
					hd.setTenRap(txttenrap.getText());
					DefaultTableModel model = (DefaultTableModel) table.getModel() ; 
					model.addRow(
							new Object[] { 
									hd.getMaHD()+"" ,
									hd.getTenPhim(),
									hd.getSoBong()+"",
									hd.getSoNuoc()+"",
									hd.getSoVe()+"",
									hd.getTongTien()+"",
									hd.getViTriGhe(),
									hd.getTenRap(),
							});
					JDBCUtil.update(hd);  
					JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công ! ");
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btncapnhat.setBounds(190, 484, 89, 62);
		add(btncapnhat);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(255, 128, 192));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hoadon hd =new hoadon() ; 
				hd.setMaHD(Integer.parseInt(txtmahoadon.getText())); 
				JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công ! ");
				JDBCUtil.delete(hd); 
				showhoadon(JDBCUtil.findAll()) ; 
			}
		});
		btnxoa.setBounds(386, 484, 89, 62);
		add(btnxoa);
		
		JButton btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(255, 128, 192));
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hoadon hd = new hoadon() ; 
				hd.setMaHD(Integer.parseInt(txtmahoadon.getText()));
				JDBCUtil.findBymahoadon(hd);
				showhoadon(JDBCUtil.findBymahoadon(hd));
			}
		});
		btntimkiem.setBounds(586, 484, 89, 62);
		add(btntimkiem);
		
		JButton btnlammoi = new JButton("Làm Mới");
		btnlammoi.setBackground(new Color(255, 128, 192));
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmahoadon.setText("");
				cbtenphim.setSelectedItem(-1);	
				txtsobong.setText("");
				txtsonuoc.setText("");
				txtsove.setText("");
				txttongtien.setText("");
				txtvitrighe.setText("");
				txttenrap.setText("");
			}
		});
		btnlammoi.setBounds(771, 484, 89, 62);
		add(btnlammoi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 456, 850, 25);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(237, 11, 15, 287);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(586, 11, 15, 287);
		add(separator_2);
		

	}
	public void showhoadon(List<hoadon>hd) { 
		List<hoadon>Listhoadon = new ArrayList<>() ; 
		Connection connection = JDBCUtil.getConnection() ; 
		Listhoadon = hd ; 
		DefaultTableModel tableModel; 
		table.getModel() ; 
		tableModel = (DefaultTableModel)table.getModel() ; 
		tableModel.setRowCount(0); 
		Listhoadon.forEach((hoadon) -> { 
			tableModel.addRow(new Object [] {
				hoadon.getMaHD(),hoadon.getTenPhim(),
				hoadon.getSoBong(),hoadon.getSoNuoc(),hoadon.getSoVe(),
				hoadon.getTongTien(),hoadon.getViTriGhe(),hoadon.getTenRap()  
			});
		});
	}
}
