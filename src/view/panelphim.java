package view;

import java.awt.Color;
import java.awt.Font;
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
import model.phim;

public class panelphim extends JPanel {
	private JTextField txttenphim;
	private JTextField txtthangsanxuat;
	private JTextField txttrangthai;
	private static JTable table;
	private JLabel lblNewLabel_1;
	
	public panelphim() {
		Connection connection = JDBCUtil.getConnection();
		setBounds(134, 11, 870, 557);
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên phim");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 26, 82, 38);
		add(lblNewLabel);
		
		txttenphim = new JTextField();
		txttenphim.setBounds(113, 36, 101, 20);
		add(txttenphim);
		txttenphim.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hãng sản xuất");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 236, 204, 38);
		add(lblNewLabel_1);
		
//		lblNewLabel_1 = new JLabel("Hãng sản xuất");
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblNewLabel_1.setBounds(10, 106, 10, 38);
//		add(lblNewLabel_1);
		
		txtthangsanxuat = new JTextField();
		txtthangsanxuat.setBounds(113, 143, 101, 20);
		add(txtthangsanxuat);
		txtthangsanxuat.setColumns(10);
		lblNewLabel_1.setBounds(10, 236, 82, 38);
		
		txttrangthai = new JTextField();
		txttrangthai.setBounds(113, 247, 101, 20);
		add(txttrangthai);
		txttrangthai.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày chiếu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 348, 82, 38);
		add(lblNewLabel_3);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(258, 11, 480, 535);
		add(scrollpane);
		
		table = new JTable();
		scrollpane.setViewportView(table);
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
					"T\u00EAn Phim", "H\u00E3ng s\u1EA3n xu\u1EA5t", "Ng\u00E0y chi\u1EBFu", "Th\u00E1ng chi\u1EBFu", "N\u0103m chi\u1EBFu ", "Tr\u1EA1ng th\u00E1i"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setPreferredWidth(57);
		
		
		JComboBox cbngaychieu = new JComboBox();
		cbngaychieu.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		cbngaychieu.setBounds(113, 357, 101, 22);
		add(cbngaychieu);
		
		JComboBox cbthangchieu = new JComboBox();
		cbthangchieu.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbthangchieu.setBounds(113, 435, 101, 22);
		add(cbthangchieu);
		
		JComboBox cbnamchieu = new JComboBox();
		cbnamchieu.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"}));
		cbnamchieu.setBounds(113, 509, 101, 22);
		add(cbnamchieu);
		
		JButton btnnhap = new JButton("Nhập");
		btnnhap.setBackground(new Color(255, 255, 255));
		btnnhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					phim p = new phim();
					p.setTenPhim(txttenphim.getText());
					p.setNgayChieu(Integer.parseInt(cbngaychieu.getSelectedItem().toString()));
					p.setThangChieu(Integer.parseInt(cbthangchieu.getSelectedItem().toString()));
					p.setNamChieu(Integer.parseInt(cbnamchieu.getSelectedItem().toString()));
					p.setHangSX(txtthangsanxuat.getText());
					p.setTrangThai(txttrangthai.getText());
					JOptionPane.showMessageDialog(null, "Nhập phím thành công !");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
							model.addRow(new Object[] {
							p.getTenPhim(), p.getNgayChieu()+"", p.getThangChieu()+"", p.getNamChieu()+"", p.getHangSX(), p.getTrangThai()
					});
							JDBCUtil.insert(p);
				} catch (NumberFormatException | HeadlessException e1) {
					e1.printStackTrace();
					// TODO: handle exception
				}
				
			}
		});
		btnnhap.setBounds(771, 357, 89, 70);
		add(btnnhap);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(255, 255, 255));
		btnxoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				phim p = new phim();
				p.setTenPhim(txttenphim.getText());
				JOptionPane.showMessageDialog(null, "Xóa phím thành công !");
				JDBCUtil.delete(p);
				showphim(JDBCUtil.findAll2());
				
			}
		});
		btnxoa.setBounds(771, 463, 89, 70);
		add(btnxoa);
		
		JButton btnlammoi = new JButton("Làm mới");
		btnlammoi.setBackground(new Color(255, 255, 255));
		btnlammoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txttenphim.setText("");
				txtthangsanxuat.setText("");
				txttrangthai.setText("");
				cbngaychieu.setSelectedItem("");
				cbthangchieu.setSelectedItem("");
				cbnamchieu.setSelectedItem("");
				
			}
		});
		btnlammoi.setBounds(771, 236, 89, 70);
		add(btnlammoi);
		
		JButton btncapnhat = new JButton("Cập nhật");
		btncapnhat.setBackground(new Color(255, 255, 255));
		btncapnhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					phim p = new phim();
					p.setTenPhim(txttenphim.getText());
					p.setNgayChieu(Integer.parseInt(cbngaychieu.getSelectedItem().toString()));
					p.setThangChieu(Integer.parseInt(cbthangchieu.getSelectedItem().toString()));
					p.setNamChieu(Integer.parseInt(cbnamchieu.getSelectedItem().toString()));
					p.setHangSX(txtthangsanxuat.getText());
					p.setTrangThai(txttrangthai.getText());
					JDBCUtil.update(p);
					JOptionPane.showMessageDialog(null, "Cập nhật phim thành công! ");
					showphim(JDBCUtil.findAll2());
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
			}
		});
		btncapnhat.setBounds(771, 117, 89, 70);
		add(btncapnhat);
		
		JButton btntimkiem = new JButton("Tìm kiếm");
		btntimkiem.setBackground(new Color(255, 255, 255));
		btntimkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				phim p = new phim();
				p.setTenPhim(txttenphim.getText());
				JDBCUtil.findBytenphim(p);
				showphim(JDBCUtil.findBytenphim(p));
			}
		});
		btntimkiem.setBounds(771, 11, 89, 70);
		add(btntimkiem);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(748, 10, 30, 536);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(229, 11, 19, 535);
		add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("Tháng chiếu ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 426, 93, 38);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Năm chiếu ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 504, 82, 31);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Trạng thái");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 132, 93, 38);
		add(lblNewLabel_2);
		

		
		
	}
	public void showphim(List<phim>p) {
		Connection connection = JDBCUtil.getConnection();
		List<phim>Listphim = new ArrayList<>();
		Listphim = p;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		Listphim.forEach((phim) -> {
			tableModel.addRow(new Object[] {
					phim.getTenPhim(), phim.getHangSX(), phim.getNgayChieu(), phim.getThangChieu(), phim.getNamChieu(), phim.getTrangThai()
			});
		});
	}
}
