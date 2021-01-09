package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GoodsDao;
import model.Goods;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GoodsAddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField GoodsNameTextField;
	private JTextField GoodsPriceTextField;
	private JTextField GoodsNumTextField;
	private JTextField GoodsIdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsAddFrame frame = new GoodsAddFrame();
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
	public GoodsAddFrame() {
		setTitle("商品添加");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("商品名称：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("商品价格 ：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		GoodsNameTextField = new JTextField();
		GoodsNameTextField.setColumns(10);
		
		GoodsPriceTextField = new JTextField();
		GoodsPriceTextField.setColumns(10);
		
		JButton submitgoodsButton = new JButton("提交");
		submitgoodsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				submitgoods(e2);
			}
			
		});
		submitgoodsButton.setIcon(new ImageIcon(GoodsAddFrame.class.getResource("/images/登录 (2).png")));
		submitgoodsButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				resetValue(e1);
			}
		});
		resetButton.setIcon(new ImageIcon(GoodsAddFrame.class.getResource("/images/重置.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("商品数量：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		
		GoodsNumTextField = new JTextField();
		GoodsNumTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("商品编号：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		GoodsIdTextField = new JTextField();
		GoodsIdTextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(GoodsNumTextField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addComponent(GoodsPriceTextField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(GoodsIdTextField, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(GoodsNameTextField, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
					.addGap(196))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(submitgoodsButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
					.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(101))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addComponent(lblNewLabel_3)
					.addContainerGap(537, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(GoodsIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(GoodsNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(GoodsPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(GoodsNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(submitgoodsButton))
					.addGap(63))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitgoods(ActionEvent e2) {
		// TODO Auto-generated method stub
		String GoodsId=GoodsIdTextField.getText().toString();
		String GoodsName=GoodsNameTextField.getText().toString();
		
		int GoodsPrice = Integer.parseInt( GoodsPriceTextField.getText().toString());
		int GoodsNum=Integer.parseInt(GoodsNumTextField.getText().toString());
		if(StringUtil.isEmpty(GoodsName))
		{
			JOptionPane.showMessageDialog(this,"商品名称不能为空！");
			return ;
		}
		Goods goods=new Goods();
		goods.setId(GoodsId);
		goods.setName(GoodsName);
		goods.setPrice(GoodsPrice);
		goods.setNum(GoodsNum);
		GoodsDao goodsdao=new GoodsDao();
		if(goodsdao.addGoods(goods))
		{
			JOptionPane.showMessageDialog(this,"商品添加成功！");
		}
		else
		{
			JOptionPane.showMessageDialog(this,"商品添加失败！");
		}
		resetValue(e2);
		}

	protected void resetValue(ActionEvent e1) {
		// TODO Auto-generated method stub
		GoodsIdTextField.setText("");
		GoodsNameTextField.setText("");
		GoodsPriceTextField.setText("");
		GoodsNumTextField.setText("");
		
	}
}
