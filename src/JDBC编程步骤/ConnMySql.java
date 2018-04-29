package JDBC编程步骤;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMySql {
	public static String url="jdbc:mysql://127.0.0.1:3306/test";
	public static String sql="select * from user";
	
	public static void main(String[]args){
		try {
			//1.加载驱动，使用反射知识
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//2.使用DriverManager获取数据库连接
			//其中返回的Connection就代表了Java程序和数据库的连接
			Connection conn=DriverManager.getConnection(ConnMySql.url,"root","xiaoma96");
			//3.使用Connection来创建一个Statement对象
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(ConnMySql.sql);
			while(rs.next()){
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
