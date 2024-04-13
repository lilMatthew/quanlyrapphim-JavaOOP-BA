package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.JDBCUtil;
import model.nguoidung;
import java.awt.Toolkit;

public class JFrameDangNhap extends JFrame {
	private JPanel contentPane;
	private JTextField txtmatkhau;
	private JTextField txttendangnhap;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					JFrameDangNhap frame = new JFrameDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrameDangNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Downloads\\cinema_1f3a6.png"));
		Connection connection = JDBCUtil.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 425);
		setTitle("Đăng nhập tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(67, 54, 101, 39);
		contentPane.add(lblNewLabel);
		
		txttendangnhap = new JTextField();
		txttendangnhap.setBounds(199, 55, 227, 39);
		contentPane.add(txttendangnhap);
		txttendangnhap.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(67, 151, 101, 39);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chkrrememberme = new JCheckBox("Remember me");
		chkrrememberme.setFont(new Font("Tahoma", Font.BOLD, 12));
		chkrrememberme.setBounds(199, 216, 117, 23);
		contentPane.add(chkrrememberme);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(133,  213,  385,  -20);
		contentPane.add(separator);
		
		JButton btndangnhap = new JButton("Đăng nhập ");
		btndangnhap.setBackground(new Color(192, 192, 192));
//		btndangnhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btndangnhap.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String tendangnhap = txttendangnhap.getText();
				String matkhau = txtmatkhau.getText();
				
				nguoidung nd = JDBCUtil.login(tendangnhap, matkhau);
				
				if(nd == null) {
					JOptionPane.showMessageDialog(btndangnhap, "Tài khoản không tồn tại hoặc mật khẩu không đúng !");				
				}else {
					JOptionPane.showMessageDialog(btndangnhap, "Đăng nhập thành công !");
					EventQueue.invokeLater(new Runnable(){
						public void run() {
							try {
								homescreen frame = new homescreen();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				setVisible(false);
				dispose();
			}
		});
		btndangnhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btndangnhap.setBounds(101, 278, 101, 62);
		contentPane.add(btndangnhap);
		
		JButton btnlammoi = new JButton("Làm mới");
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
				}
		});
		btnlammoi.setBackground(new Color(192, 192, 192));
		btnlammoi.setBounds(322, 279, 101, 62);
		contentPane.add(btnlammoi);
		
		JSeparator seperator = new JSeparator();
		seperator.setBounds(10, 251, 531, 13);
		contentPane.add(seperator);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setBounds(199, 152, 227, 39);
		contentPane.add(txtmatkhau);
}
}   
		