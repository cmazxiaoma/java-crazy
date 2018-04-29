package JDBC编程步骤;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParams(String file) throws IOException{
		Properties ppt=new Properties();
		ppt.load(ExecuteDDL.class.getResourceAsStream(file));
		driver=ppt.getProperty("driver");
		url=ppt.getProperty("url");
		user=ppt.getProperty("user");
		pass=ppt.getProperty("pass");
	}
	
	public int insertData(String sql) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, pass);
		Statement s=con.createStatement();
		{
			return s.executeUpdate(sql);
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
		ExecuteDML ed=new ExecuteDML();
		ed.initParams("/mysql.Properties");
		int result=ed.insertData("insert into user values(null,'test','test')");
		System.out.println("系统中共有"+result+"条记录被影响");
	}
}
