package dao;



import java.sql.Connection;
import java.sql.SQLException;

import String.Dbutil;

public class BaseDao {
	public Connection con =new Dbutil().getCon();
	public void Close()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

