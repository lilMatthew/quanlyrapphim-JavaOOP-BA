//package view;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JSeparator;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//import database.JDBCUtil;
//import model.nguoidung;
//import java.awt.Toolkit;
//
//public class swingrapphim extends JFrame {
//	private JPanel contentPane;
//	private JTextField txtusername;
//	private JPasswordField txtpassword;
//	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					swingrapphim frame = new swingrapphim();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}				
//			}
//		});
//	}
//	public swingrapphim() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Downloads\\login.png"));
//		Connection connection = JDBCUtil.getConnection() ; 
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(134, 11, 496, 435);
//		//Connection connection = JDBCUtil.getConnection() ; 
//		setTitle("login screen");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.PINK);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Đăng nhập người dùng ");
//		lblNewLabel.setBackground(new Color(138, 43, 226));
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
//		lblNewLabel.setBounds(133, 28, 162, 30);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("username");
//		lblNewLabel_1.setBackground(new Color(219, 112, 147));
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblNewLabel_1.setBounds(35, 90, 73, 22);
//		contentPane.add(lblNewLabel_1);
//		
//		txtusername = new JTextField();
//		txtusername.setBounds(133, 92, 226, 20);
//		contentPane.add(txtusername);
//		txtusername.setColumns(10);
//		
//		JLabel lblNewLabel_2 = new JLabel("password");
//		lblNewLabel_2.setBackground(SystemColor.textHighlight);
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblNewLabel_2.setBounds(35, 141, 73, 22);
//		contentPane.add(lblNewLabel_2);
//		
//		JCheckBox chkrememberme = new JCheckBox("remember me");
//		chkrememberme.setFont(new Font("Tahoma", Font.BOLD, 12));
//		chkrememberme.setBounds(133, 170, 109, 23);
//		contentPane.add(chkrememberme);
//		
//		JSeparator separator = new JSeparator();
//		separator.setBounds(39, 213, 385, -20);
//		contentPane.add(separator);
//		
//		JButton btnlogin = new JButton("login");
//		btnlogin.setBackground(new Color(0, 128, 128));
//		btnlogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String tennguoidung = txtusername.getText() ;
//				String matkhau = txtpassword.getText() ; 
//				
//				nguoidung nguoidung = JDBCUtil.login(tennguoidung, matkhau); 
//				if ( nguoidung == null ) { 
//					JOptionPane.showMessageDialog(btnlogin,"tài khoản không tồn tại ");
//				} else { 
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								homescreen frame = new homescreen();
//								frame.setVisible(true);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					});
//				}
//				setVisible(false); 
//				dispose() ; 
// 			}
//		});
//		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnlogin.setBounds(140, 227, 89, 23);
//		contentPane.add(btnlogin);
//		
//		JButton btnReset = new JButton("reset");
//		btnReset.setBackground(new Color(0, 128, 128));
//		btnReset.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			dispose() ; 
//			}
//		});
//		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnReset.setBounds(254, 227, 89, 23);
//		contentPane.add(btnReset);
//		
//		txtpassword = new JPasswordField();
//		txtpassword.setBounds(133, 143, 226, 20);
//		contentPane.add(txtpassword);
//	}
//}
