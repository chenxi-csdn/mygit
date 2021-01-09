package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;

import model.UserType;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private UserType userType;
	private Object userObject;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(UserType usertype,Object userObject) {
		setTitle("超市收银系统的主界面");
		this.userType=userType;
		this.userObject=userObject;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 696);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统设置");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/系统设置.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出系统");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				if(JOptionPane.showConfirmDialog(MainFrame.this,"真的确定退出么？")==JOptionPane.OK_OPTION)
				
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/退出系统.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("商品管理");
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/商品管理.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("商品添加");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				addGoods(e3);
				
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/添加.png")));
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("商品管理");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				GoodsListFrame glf=new GoodsListFrame();
				glf.setVisible(true);
				desktopPane.add(glf);
				
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/列表.png")));
		mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("帮助");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/帮助.png")));
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("关于我们");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				aboutUs(e1);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/images/关于我们.png")));
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(854)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(68)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(509, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_desktopPane);
	}

	//desktopPane=new JDeskPane();
	protected void addGoods(ActionEvent e3) {
		// TODO Auto-generated method stub
		GoodsAddFrame gaf=new GoodsAddFrame();
		gaf.setVisible(true);
	//desktopPane.add(gaf);
	}

	protected void aboutUs(ActionEvent e2) {
		// TODO Auto-generated method stub
		String info="四班陈曦";
		info +="吉大课设";
		JOptionPane.showMessageDialog(this,info);
	}

}
