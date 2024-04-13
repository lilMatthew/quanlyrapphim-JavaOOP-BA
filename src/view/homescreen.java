package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class homescreen extends JFrame {
	private JPanel contentPane;
	private panelhoadon panelhoadon;
	private panelkhachhang panelkhachhang;
	private panelphim panelphim;
	private panelnhanvien panelnhanvien;
	private panelrap panelrap;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					homescreen frame = new homescreen();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	public homescreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Downloads\\cinema.png"));
		panelkhachhang = new panelkhachhang();
		panelkhachhang.setLocation(0, 0);
		panelhoadon = new panelhoadon();
		panelhoadon.setLocation(0, 0);
		panelphim = new panelphim();
		panelphim.setLocation(0, 0);
		panelnhanvien = new panelnhanvien() ; 
		panelnhanvien.setLocation(0, 0);
		panelrap = new panelrap() ; 
		panelrap.setLocation(0, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnhoadon = new JButton("Hóa Đơn");
		btnhoadon.setRequestFocusEnabled(false);
		btnhoadon.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnhoadon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuClicked(panelhoadon);
				
			}
		});
		
		btnhoadon.setForeground(new Color(0, 0, 0));
		btnhoadon.setBackground(new Color(255, 255, 0));
		btnhoadon.setBounds(10, 11, 114, 65);
		contentPane.add(btnhoadon);
		
		JButton btnkhachhang = new JButton("Khách Hàng");
		btnkhachhang.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnkhachhang.setRequestFocusEnabled(false);
		btnkhachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelkhachhang);
			}
		});
		btnkhachhang.setForeground(new Color(64, 0, 64));
		btnkhachhang.setBackground(new Color(255, 255, 0));
		btnkhachhang.setBounds(10, 104, 114, 65);
		contentPane.add(btnkhachhang);
		
		JButton btnPhim = new JButton("Phim");
		btnPhim.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPhim.setRequestFocusEnabled(false);
		btnPhim.setBackground(new Color(255, 255, 0));
		btnPhim.setForeground(new Color(64, 0, 64));
		btnPhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelphim);
			}
		});
		
		btnPhim.setBounds(10, 203, 114, 65);
		contentPane.add(btnPhim);
		
		JPanel panel_main = new JPanel();
		panel_main.setBackground(new Color(64, 128, 128));
		panel_main.setBounds(134, 11, 870, 557);
		contentPane.add(panel_main);
		panel_main.setLayout(null);
	
	
		
				
		panel_main.add(panelhoadon);
		panel_main.add(panelkhachhang);
		panel_main.add(panelphim);
		panel_main.add(panelnhanvien) ;
		panel_main.add(panelrap);
		menuClicked(panelhoadon);
		panelhoadon.setLayout(null);
		
		JButton btnnhanvien = new JButton("Nhân Viên");
		btnnhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelnhanvien);
			}
		});
		btnnhanvien.setBackground(new Color(255, 255, 0));
		btnnhanvien.setBounds(10, 300, 114, 65);
		contentPane.add(btnnhanvien);
		
		JButton btnrap = new JButton("Rạp");
		btnrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelrap) ;
			}
		});
		btnrap.setBackground(new Color(255, 255, 0));
		btnrap.setForeground(new Color(0, 0, 0));
		btnrap.setBounds(10, 399, 114, 65);
		contentPane.add(btnrap);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose() ; 
			}
		});
		btnThot.setBackground(new Color(255, 255, 0));
		btnThot.setBounds(10, 503, 114, 65);
		contentPane.add(btnThot);	
	}
	public void menuClicked(JPanel panel) {
		panelkhachhang.setVisible(false);
		panelhoadon.setVisible(false);
		panelphim.setVisible(false);
		panelnhanvien.setVisible(false);
		panelrap.setVisible(false);
		panel.setVisible(true);
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(254, 86, 33));
		}
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(254, 86, 33));
		}
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}
}
