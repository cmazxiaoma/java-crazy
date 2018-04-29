package JDBC编程步骤;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.datatype.DatatypeFactory;

import com.mysql.jdbc.Util;


public class ExecuteDDL {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	
	public void createTable(String sql) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,pass);
		Statement s=conn.createStatement();
		{
			s.executeUpdate(sql);
		}
	}
	
	public void initParam(String paramFile) throws FileNotFoundException, IOException{
		Properties props=new Properties();
		InputStream is =Properties.class.getResourceAsStream(paramFile);
	    props.load(is);
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		user=props.getProperty("user");
		pass=props.getProperty("pass");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
		ExecuteDDL ed=new ExecuteDDL();
		ed.initParam("/mysql.properties");
		ed.createTable("create table teacher "+"( id int auto_increment primary key, "+" name varchar(250),age int );");
		System.out.println("创建表成功");
	}

}
