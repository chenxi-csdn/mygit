package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import dao.GuestDao;
import model.Admin;
import model.Guest;
import model.UserType;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passWordTextField;
    private JComboBox userTypeComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogFrame frame = new LogFrame();
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
	public LogFrame() {
		setTitle("小超市收银登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("小超市收银系统");
		lblNewLabel.setIcon(new ImageIcon(LogFrame.class.getResource("/images/商城.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setIcon(new ImageIcon(LogFrame.class.getResource("/images/账号.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("密码：");
		lblNewLabel_2.setIcon(new ImageIcon(LogFrame.class.getResource("/images/密码 (2).png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		passWordTextField = new JTextField();
		passWordTextField.setColumns(10);
		//new String[]
		//JComboBox
		userTypeComboBox = new JComboBox();//1
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.GUEST}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton loginButton = new JButton("登录");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				loginAct(e2);
			}
		});
		loginButton.setIcon(new ImageIcon(LogFrame.class.getResource("/images/登录 (2).png")));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				restValue(e1);
				
			}
		});
		resetButton.setIcon(new ImageIcon(LogFrame.class.getResource("/images/重置.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("用户类型：");
		lblNewLabel_3.setIcon(new ImageIcon(LogFrame.class.getResource("/images/用户 (1).png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(219)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passWordTextField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(156)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel_1)
							.addGap(30)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(passWordTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_3)
							.addGap(53)
							.addComponent(loginButton)))
					.addContainerGap(257, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent e2) {
		// TODO Auto-generated method stub
		String userName=userNameTextField.getText().toString();
		String passWord=passWordTextField.getText().toString();
		UserType selectedItem=(UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName))
		{
			JOptionPane.showMessageDialog(this,"用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(passWord))
		{
			JOptionPane.showMessageDialog(this,"密码不能为空！");
			return;
		}
		Admin admin=null;
		Guest guest=null;
		if("收银员".equals(selectedItem.getName()))
				{
			//系统管理员登录
			AdminDao admindao=new AdminDao();
			Admin  adminTmp=new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(passWord);
			 admin =admindao.login(adminTmp);
			if(admin==null)
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this,"欢迎用户登录");
			this.dispose();
			
			new MainFrame(selectedItem,admin).setVisible(true);
			
				}
		if("顾客".equals(selectedItem.getName()))
		{
			GuestDao guestdao=new GuestDao();
			Guest  guestTmp=new Guest();
			guestTmp.setName(userName);
			guestTmp.setPassword(passWord);
			 guest=guestdao.login(guestTmp);
			if(guest==null)
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this,"欢迎用户登录");
			this.dispose();
			
			new GuestFrame().setVisible(true);
		}
					
		
		
	}

	protected void restValue(ActionEvent e1) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passWordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}
