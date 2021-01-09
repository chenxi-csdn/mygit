package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 商品信息与数据库操作
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goods;
import util.StringUtil;


public class GoodsDao extends BaseDao {
	public boolean addGoods(Goods g)
	{
		String sql="insert into s_goods values(?,?,?,?)";
		try {
			
			java.sql.PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1,g.getId());
			preparedStatement.setString(2,g.getName());
			preparedStatement.setLong(3,g.getPrice());
			preparedStatement.setLong(4,g.getNum());
			if(preparedStatement.executeUpdate()>0)
					return true;
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Goods> getGoodsList(Goods goods)
	{
		List<Goods> retList= new ArrayList<Goods>();
		String sqlString="SELECT * from s_goods";
		if(!StringUtil.isEmpty(goods.getName()))
		{
			sqlString = sqlString+" where name like '%"+goods.getName()+"%'";
			
		}
//		"select * from s_goods where name like ?"; ps.setString(1, "%"+goods.getName()+"%");
		try {
			PreparedStatement preparedStatement=con.prepareStatement(sqlString);
//			preparedStatement.setString(1,"%"+goods.getName()+"%");
			ResultSet executeQuery=preparedStatement.executeQuery();
			while(executeQuery.next())
			{
				Goods gds=new Goods();
				gds.setId(executeQuery.getString("id"));
				gds.setName(executeQuery.getString("name"));
				gds.setPrice(executeQuery.getInt("price"));
				gds.setNum(executeQuery.getInt("num"));
				retList.add(gds);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(String name)
	{
		String sql="delete from s_goods where name=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,name);
			
			if(preparedStatement.executeUpdate()>0)
			{
				return true;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	public boolean update(Goods goods)
	{
		String sql="update s_goods set name=?,price=? and num=? where id =?";
//	sql=sql+",price=? and num=? ";
//		sql=sql+"where id=?";
//		PreparedStatement preparedStatement;
	
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(4,goods.getId());
			preparedStatement.setString(1,goods.getName());
			preparedStatement.setInt(2,goods.getPrice());
			preparedStatement.setInt(3,goods.getNum());
			preparedStatement.setString(4,goods.getId());
			if(preparedStatement.executeUpdate()>0)
			{
				return true;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
		
	}

}
