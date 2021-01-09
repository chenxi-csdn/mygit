package view;

/**
 * 
 * 
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.GoodsDao;
import model.Goods;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GoodsListFrame extends JInternalFrame {
	private JTextField SearchGoodsNameTextField;
	private JTable GoodsListTable;
	private JTextField editGoodsNameTextField;
	private JTextField editGoodsIdTextField;
	private JTextField editGoodsPriceTextField;
	private JTextField editGoodsNumTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsListFrame frame = new GoodsListFrame();
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
	public GoodsListFrame() {
		setTitle("商品管理");
		setBounds(100, 100, 637, 623);
		
		JLabel lblNewLabel = new JLabel("商品名称：");
		lblNewLabel.setIcon(new ImageIcon(GoodsListFrame.class.getResource("/images/商城.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		SearchGoodsNameTextField = new JTextField();
		SearchGoodsNameTextField.setColumns(10);
		
		JButton SearchButton = new JButton("查询");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Goods gds=new Goods();
				gds.setName(SearchGoodsNameTextField.getText().toString());
				setTable(gds);
			}
		});
		SearchButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		SearchButton.setIcon(new ImageIcon(GoodsListFrame.class.getResource("/images/查询.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton ExitSearchButton = new JButton("退出界面");
		ExitSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(GoodsListFrame.this,"真的确定退出么？")==JOptionPane.OK_OPTION)
					
					System.exit(0);
			}
		});
		ExitSearchButton.setIcon(new ImageIcon(GoodsListFrame.class.getResource("/images/退出系统.png")));
		ExitSearchButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("商品名：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("商品编号：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		JLabel lblNewLabel_3 = new JLabel("商品价格：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		editGoodsNameTextField = new JTextField();
		editGoodsNameTextField.setColumns(10);
		
		editGoodsIdTextField = new JTextField();
		editGoodsIdTextField.setColumns(10);
		
		editGoodsPriceTextField = new JTextField();
		editGoodsPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("商品数量：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 13));
		
		editGoodsNumTextField = new JTextField();
		editGoodsNumTextField.setColumns(10);
		
		JButton submitEditButton = new JButton("确认修改");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				submitEditAct(e1);
			}
		});
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		JButton submitDeleteButton = new JButton("删除");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				deleteGoodsAct(e2);
			}
		});
		submitDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		JButton getMoneyButton = new JButton("收银并统计销售情况");
		getMoneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActgetMoney();
			}
		});
		getMoneyButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(SearchGoodsNameTextField, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(187)
							.addComponent(ExitSearchButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editGoodsNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editGoodsIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editGoodsPriceTextField, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(editGoodsNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(getMoneyButton, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
											.addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
											.addGap(15)))))
							.addGap(47)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(SearchGoodsNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(SearchButton)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(ExitSearchButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(editGoodsNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(editGoodsIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblNewLabel_3))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(editGoodsPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(editGoodsNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(submitEditButton)
								.addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addComponent(getMoneyButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(67))
		);
		
		GoodsListTable = new JTable();
		GoodsListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//JOptionPane.showMessageDialog(null,"不允许直接修改");
				selectedTableRow(e);
			}
		});
		GoodsListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u4EF7\u683C", "\u5546\u54C1\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(GoodsListTable);
		getContentPane().setLayout(groupLayout);
setTable(new Goods());
	}
	protected void ActgetMoney() {
		// TODO Auto-generated method stub
		DefaultTableModel dft=(DefaultTableModel)GoodsListTable.getModel();
		String Name=(dft.getValueAt(GoodsListTable.getSelectedRow(),1).toString());
		int price=Integer.parseInt(dft.getValueAt(GoodsListTable.getSelectedRow(),2).toString());
		int num=Integer.parseInt(dft.getValueAt(GoodsListTable.getSelectedRow(),3).toString());
		int Count=price*num;
		String info="此顾客一共消费";
		info +=Count;
		info +="元！，请给他一个八折";
		info +="即实际收款";
		info +=Count*0.8;
		info +="元,共卖出";
		info +=num;
		info +="数量的";
		info +=Name;
		
		//.deleteGoodsAct();
		JOptionPane.showMessageDialog(this,info);
		System.exit(0);
	}

	protected void deleteGoodsAct(ActionEvent e2) {
		// TODO Auto-generated method stub
		int index=GoodsListTable.getSelectedRow();
		if(JOptionPane.showConfirmDialog(this,"请问您确定删除么？")!=JOptionPane.OK_OPTION)
		{
			return;
		}
		if(index==-1)
		{
			JOptionPane.showMessageDialog(this,"请选择要删除的数据");
			return ;
		}
		
		DefaultTableModel dft=(DefaultTableModel)GoodsListTable.getModel();
		String id=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),0);
		String name=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),1);
//		String price=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),2);
//		String id=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),3);
		GoodsDao goodsdao=new GoodsDao();
		if(goodsdao.delete(name))
		{
			JOptionPane.showMessageDialog(this,"删除成功");
		}else
		{
			JOptionPane.showMessageDialog(this,"删除失败");
		}
		setTable(new Goods());
	}

	protected void submitEditAct(ActionEvent e1) {
		// TODO Auto-generated method stub
		GoodsDao goodsdao=new GoodsDao();
		int index=GoodsListTable.getSelectedRow();
		if(index==-1)
		{
			JOptionPane.showMessageDialog(this,"请选择要修改的数据");
			return ;
		}
		DefaultTableModel dft=(DefaultTableModel)GoodsListTable.getModel();

		String goodsName= dft.getValueAt(GoodsListTable.getSelectedRow(),1).toString();
		String goodsId=dft.getValueAt(GoodsListTable.getSelectedRow(),0).toString();
//		int goodsPrice=Integer.parseInt(dft.getValueAt(GoodsListTable.getSelectedRow(),2).toString());
//		int goodsNum=Integer.parseInt(dft.getValueAt(GoodsListTable.getSelectedRow(),3).toString());
//		
		
	
//		String price=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),2);
//		String id=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),3);
		
//		editGoodsIdTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),0).toString());
//		editGoodsNameTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),1).toString());
//		editGoodsPriceTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),2).toString());
//		editGoodsNumTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),3).toString());
		//代编译的
		String editGoodsName=editGoodsNameTextField.getText().toString();
		String editGoodsId=editGoodsIdTextField.getText().toString();
		
//		if(editGoodsNameTextField.getText().toString() !=null && !editGoodsNameTextField.getText().toString() .equals("")){
//			int editGoodsPrice=Integer.parseInt(editGoodsNameTextField.getText().toString());
//			}
//		if(editGoodsNameTextField.getText().toString() !=null && !editGoodsNameTextField.getText().toString() .equals("")){
//			int editGoodsPrice=Integer.parseInt(editGoodsNameTextField.getText().toString());
//			}
		int editGoodsPrice=Integer.parseInt(editGoodsPriceTextField.getText().toString());
		int editGoodsNum=Integer.parseInt(editGoodsNumTextField.getText().toString());
		
		if(StringUtil.isEmpty(editGoodsName))
		{
			JOptionPane.showMessageDialog(this,"请填写需要修改的名称!");
			return;
		}
		
		if(goodsName.equals(editGoodsName) && goodsId.equals(editGoodsId))
		{
			JOptionPane.showMessageDialog(this,"您还没有修改!");
			return;
		}
		
		
		
		
//		String goodsId=(String) dft.getValueAt(GoodsListTable.getSelectedRow(),1);
		Goods  goods=new Goods();
		goods.setId(goodsId);
	    goods.setName(editGoodsName);
		goods.setPrice(editGoodsPrice);
		goods.setNum(editGoodsNum);
		
		if(goodsdao.update(goods))
		{
			JOptionPane.showMessageDialog(this,"修改成功");
		}else
		{
			JOptionPane.showMessageDialog(this,"修改失败");
		}
		setTable(new Goods());
		
				}

	protected void selectedTableRow(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft=(DefaultTableModel)GoodsListTable.getModel();
		//GoodsListTable.getSelectedColumn()
		editGoodsIdTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),0).toString());
		editGoodsNameTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),1).toString());
		editGoodsPriceTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),2).toString());
		editGoodsNumTextField.setText(dft.getValueAt(GoodsListTable.getSelectedRow(),3).toString());
		
}

	private void setTable(Goods goods)
	{
		DefaultTableModel dft=(DefaultTableModel)GoodsListTable.getModel();
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
