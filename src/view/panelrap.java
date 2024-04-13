package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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
import model.rap;

public class panelrap extends JPanel {
	private JTable table;
	private JTextField txttenrap;
	private JTextField txtsocho;
	
	public panelrap() {
		Connection connection = JDBCUtil.getConnection();
		setBounds(134, 11, 870, 557);
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JButton btnnhap = new JButton("Nhập");
		btnnhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					rap r = new rap();
					r.setTenRap(txttenrap.getText());
					r.setSoCho(Integer.parseInt(txtsocho.getText()));
					JOptionPane.showMessageDialog(null, "Nhập rạp thành công!");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.addRow(new Object[] {
							r.getTenRap(), r.getSoCho()+"",
					});
					JDBCUtil.insert(r);
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnnhap.setBackground(new Color(255, 128, 192));
		btnnhap.setBounds(771, 11, 89, 88);
		add(btnnhap);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					rap r = new rap() ; 
					r.setTenRap(txttenrap.getText());
					r.setSoCho(Integer.parseInt(txtsocho.getText()));
					JOptionPane.showMessageDialog(null, " Nhập rạp thành công ! ");
					DefaultTableModel model = (DefaultTableModel) table.getModel() ; 
					model.addRow(
							new Object[] { 
									r.getTenRap() , 
									r.getSoCho()+"",
							});
					JDBCUtil.update(r);;   
				} catch (NumberFormatException | HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCpNht.setBackground(new Color(255, 128, 192));
		btnCpNht.setBounds(771, 120, 89, 88);
		add(btnCpNht);
		
		JButton btntimkiem = new JButton("Tìm kiếm ");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rap r = new rap() ;
				r.setTenRap(txttenrap.getText());
				JDBCUtil.getBytenrap(r) ; 
				showrap(JDBCUtil.getBytenrap(r)) ;
			}
		});
		btntimkiem.setBackground(new Color(255, 128, 192));
		btntimkiem.setBounds(771, 458, 89, 88);
		add(btntimkiem);
		
		JButton btnlammoi = new JButton("Làm mới ");
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txttenrap.setText("");
				txttenrap.setText(""); 
			}
		});
		btnlammoi.setBackground(new Color(255, 128, 192));
		btnlammoi.setBounds(771, 346, 89, 88);
		add(btnlammoi);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rap r = new rap() ; 
				r.setTenRap(txttenrap.getText());
				JDBCUtil.delete(r);
				showrap(JDBCUtil.getrap());
			}
		});
		btnxoa.setBackground(new Color(255, 128, 192));
		btnxoa.setBounds(771, 234, 89, 88);
		add(btnxoa);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(746, 11, 15, 535);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 11, 410, 535);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"T\u00EAn r\u1EA1p", "S\u1ED1 Ch\u1ED7 ng\u1ED3i "
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(302, 11, 23, 535);
		add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Tên rạp");
		lblNewLabel.setBounds(10, 149, 68, 31);
		add(lblNewLabel);
		
		JLabel lblSCh = new JLabel("Số chỗ ");
		lblSCh.setBounds(10, 330, 68, 31);
		add(lblSCh);
		
		txttenrap = new JTextField();
		txttenrap.setBounds(89, 149, 129, 31);
		add(txttenrap);
		txttenrap.setColumns(10);
		
		txtsocho = new JTextField();
		txtsocho.setBounds(95, 330, 123, 31);
		add(txtsocho);
		txtsocho.setColumns(10);
	}
	public void showrap(List<rap>r) { 
		Connection connection = JDBCUtil.getConnection() ; 
		List<rap>Listrap = new ArrayList<>() ; 
		Listrap = r ;
		DefaultTableModel tableModel ; 
		table.getModel() ; 
		tableModel = (DefaultTableModel)table.getModel() ; 
		tableModel.setRowCount(0);
		Listrap.forEach((rap) -> { 
			tableModel.addRow(new Object[] { 
				rap.getTenRap(),rap.getSoCho()
				});
			}); 
	}
}
