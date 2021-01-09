package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.GoodsDao;
import model.Goods;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuestFrame extends JFrame {

	private JPanel contentPane;
	private JTable ShopingListTable;
	private JTextField ShopingNameTextField;
	private JTextField editShopingNameTextField;
	private JTextField editShopingIdTextField;
	private JTextField editShopingPriceTextField;
	private JTextField editShopingNumTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestFrame frame = new GuestFrame();
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
	public GuestFrame() {
		setTitle("欢迎光临吉大超市");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("欢迎光临吉大超市，优惠多多！");
		lblNewLabel.setIcon(new ImageIcon(GuestFrame.class.getResource("/images/公告小喇叭.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("商品名称：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setIcon(new ImageIcon(GuestFrame.class.getResource("/images/商品管理.png")));
		
		ShopingNameTextField = new JTextField();
		ShopingNameTextField.setColumns(10);
		
		JButton SearchShopingButton = new JButton("查询");
		SearchShopingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Goods gds=new Goods();
				gds.setName(ShopingNameTextField.getText().toString());
				setTable(gds);
			}
		});
		SearchShopingButton.setIcon(new ImageIcon(GuestFrame.class.getResource("/images/查询.png")));
		SearchShopingButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("付款");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActPay(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(GuestFrame.class.getResource("/images/付款.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(GuestFrame.this,"同学下次再来？")==JOptionPane.OK_OPTION)
				System.exit(0);
			}
			
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1.setIcon(new ImageIcon(GuestFrame.class.getResource("/images/退出系统.png")));
		
		JLabel lblNewLabel_2 = new JLabel("商品编号：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editShopingNameTextField = new JTextField();
		editShopingNameTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("商品名称：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editShopingIdTextField = new JTextField();
		editShopingIdTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("商品价格：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editShopingPriceTextField = new JTextField();
		editShopingPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("商品数量：");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		editShopingNumTextField = new JTextField();
		editShopingNumTextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(ShopingNameTextField, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(SearchShopingButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(editShopingPriceTextField)
								.addComponent(editShopingIdTextField, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editShopingNameTextField, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(editShopingNumTextField)))))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(98))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(ShopingNameTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addComponent(SearchShopingButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(editShopingNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(editShopingIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4)
							.addComponent(editShopingPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(editShopingNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		ShopingListTable = new JTable();
		ShopingListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null,"sss");
				selectedTableRow(e);
			}
		});
		ShopingListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u4EF7\u683C", "\u5546\u54C1\u6570\u91CF"
			}
		));
		scrollPane.setViewportView(ShopingListTable);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void ActPay(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft=(DefaultTableModel)ShopingListTable.getModel();
		int price=Integer.parseInt(dft.getValueAt(ShopingListTable.getSelectedRow(),2).toString());
		int num=Integer.parseInt(dft.getValueAt(ShopingListTable.getSelectedRow(),3).toString());
		int Count=price*num;
		String info="本次共需支付";
		info +=Count;
		info +="，送您一张金龙卡，欢迎下次光临！";
		JOptionPane.showMessageDialog(this,info);
		System.exit(0);
	}

	protected void selectedTableRow(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft=(DefaultTableModel)ShopingListTable.getModel();
		//GoodsListTable.getSelectedColumn()
		editShopingIdTextField.setText(dft.getValueAt(ShopingListTable.getSelectedRow(),0).toString());
		editShopingNameTextField.setText(dft.getValueAt(ShopingListTable.getSelectedRow(),1).toString());
		editShopingPriceTextField.setText(dft.getValueAt(ShopingListTable.getSelectedRow(),2).toString());
		editShopingNumTextField.setText(dft.getValueAt(ShopingListTable.getSelectedRow(),3).toString());
	}

	private void setTable(Goods goods)
	{
		DefaultTableModel dft=(DefaultTableModel)ShopingListTable.getModel();
		dft.setRowCount(0);
		GoodsDao goodsdao=new GoodsDao();
		List<Goods> goodslist=goodsdao.getGoodsList(goods);
		
		for(Goods gds:goodslist)
		{
			Vector v=new Vector();
			v.add(gds.getId());
			v.add(gds.getName());
			v.add(gds.getPrice());
			v.add(gds.getNum());
			dft.addRow(v);
		}
//		Goods.closeDao();
	}
}

	
	
	

