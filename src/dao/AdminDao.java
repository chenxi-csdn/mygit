package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDao extends BaseDao {
/**
 * 收银员登录
 */
	public Admin login(Admin admin)
	{
		String sql="select * from s_admin where name=? and password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				adminRst =new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	}

}
