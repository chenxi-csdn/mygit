package String;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_admin?&useSSL=false&serverTimezone=UTC"; // 数据库连接地址
	private String dbUserName="root"; // 用户名
	private String dbPassword="mysql1234"; // 密码
	private String jdbcName="com.mysql.cj.jdbc.Driver";
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con =null;
		try {
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		Dbutil dbUtil =new Dbutil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}