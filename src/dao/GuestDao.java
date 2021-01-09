package dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Guest;

public class GuestDao extends BaseDao {
/**
 * 收银员登录
 */
	public Guest login(Guest guest)
	{
		String sql="select * from g_admin where name=? and password=?";
		Guest guestRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, guest.getName());
			prst.setString(2, guest.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				guestRst =new Guest();
				guestRst.setId(executeQuery.getInt("id"));
				guestRst.setName(executeQuery.getString("name"));
				guestRst.setPassword(executeQuery.getString("password"));
				guestRst.setCreateDate(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guestRst;
	}

}
