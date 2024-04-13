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
import model.khachhang;
import java.awt.Font;

public class panelkhachhang extends JPanel {
	private JTextField txttenkhachhang;
	private JTextField txtsodienthoai;
	private static JTable table;
	private JTextField txtmakhachhang;
	
	public void showkhachhang(List<khachhang>k) {
		Connection connection = JDBCUtil.getConnection();
		List<khachhang>Listkhachhang = new ArrayList<>();
		Listkhachhang = k;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		Listkhachhang.forEach((khachhang) -> {
			tableModel.addRow(new Object[] {
					khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getNamSinh(), khachhang.getSdt()
			});
		}
				);
	}
	
	public panelkhachhang() {
		Connection connection = JDBCUtil.getConnection();
		setBounds(134, 11, 870, 557);
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 145, 105, 25);
		add(lblNewLabel);
		
		txttenkhachhang = new JTextField();
		txttenkhachhang.setBounds(125, 148, 106, 20);
		add(txttenkhachhang);
		txttenkhachhang.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Năm sinh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 358, 78, 25);
		add(lblNewLabel_1);
		
		JComboBox cbnamsinh = new JComboBox();
		cbnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbnamsinh.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		cbnamsinh.setBounds(125, 360, 106, 22);
		add(cbnamsinh);
		
//		JLabel lblNewLabel_2 = new JLabel("Số điện thoại");
//		lblNewLabel_1.setBounds(10, 268, 78, 25);
//		add(lblNewLabel_2);
		
		txtsodienthoai = new JTextField();
		txtsodienthoai.setBounds(125, 260, 106, 20);
		add(txtsodienthoai);
		txtsodienthoai.setColumns(10);
		
		
		JButton btnnhap = new JButton("Nhập");
		btnnhap.setBackground(new Color(255, 128, 192));
		btnnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					khachhang kh = new khachhang();
					kh.setMaKH(Integer.parseInt(txtmakhachhang.getText()));
					kh.setTenKH(txttenkhachhang.getText());
					kh.setNamSinh(Integer.parseInt(cbnamsinh.getSelectedItem().toString()));
					kh.setSdt(Integer.parseInt(txtsodienthoai.getText()));
					JOptionPane.showMessageDialog(null, "Nhập khách hàng thành công !");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] {
							kh.getMaKH()+"", kh.getTenKH(), kh.getNamSinh()+"", kh.getSdt()+""
					});
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		
	});
		btnnhap.setBounds(764, 469, 96, 77);
		add(btnnhap);
		
		JButton btncapnhat = new JButton("Cập nhật");
		btncapnhat.setBackground(new Color(255, 128, 192));
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					khachhang kh = new khachhang();
					kh.setMaKH(Integer.parseInt(txtmakhachhang.getText()));
					kh.setTenKH(txttenkhachhang.getText());
					kh.setNamSinh(Integer.parseInt(cbnamsinh.getSelectedItem().toString()));
					kh.setSdt(Integer.parseInt(txtsodienthoai.getText()));
					JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công !");
					showkhachhang(JDBCUtil.findAll1());
					JDBCUtil.update(kh);
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btncapnhat.setBounds(764, 359, 96, 77);
		add(btncapnhat);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(255, 128, 192));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khachhang kh = new khachhang();
				kh.setMaKH(Integer.parseInt(txtmakhachhang.getText()));
				JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công !");
				JDBCUtil.delete(kh);
				showkhachhang(JDBCUtil.findAll1());				
			}
		});
		btnxoa.setBounds(764, 242, 96, 77);
		add(btnxoa);
		
		JButton btnlammoi = new JButton("Làm mới");
		btnlammoi.setBackground(new Color(255, 128, 192));
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmakhachhang.setText("");
				txttenkhachhang.setText("");
				cbnamsinh.setActionCommand("");
				txtsodienthoai.setText("");
			}
		});
		btnlammoi.setBounds(764, 119, 96, 77);
		add(btnlammoi);
		
		JButton btntimkiem = new JButton("Tìm kiếm");
		btntimkiem.setBackground(new Color(255, 128, 192));
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khachhang kh = new khachhang();
				kh.setMaKH(Integer.parseInt(txtmakhachhang.getText()));
				JDBCUtil.findBymakhachhang(kh);
				showkhachhang(JDBCUtil.findBymakhachhang(kh));
				
			}
		});
		btntimkiem.setBounds(764, 11, 96, 77);
		add(btntimkiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 11, 476, 535);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
						"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "N\u0103m sinh ", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		
		JLabel lblNewLabel_3 = new JLabel("Mã khách hàng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 37, 105, 25);
		add(lblNewLabel_3);
		
		txtmakhachhang = new JTextField();
		txtmakhachhang.setBounds(125, 40, 106, 20);
		add(txtmakhachhang);
		txtmakhachhang.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(749, 11, 23, 535);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Số điện thoại");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 253, 96, 31);
		add(lblNewLabel_2);
}
}
