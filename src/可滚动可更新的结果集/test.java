package 可滚动可更新的结果集;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class test{
	private String paramsFile="/mysql.properties";
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParams(){
		Properties ppt=new Properties();
		try{
		ppt.load(test.class.getResourceAsStream(paramsFile));
		driver=ppt.getProperty("driver");
		url=ppt.getProperty("url");
		user=ppt.getProperty("user");
		pass=ppt.getProperty("pass");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		test t=new test();
		t.initParams();
		t.query("select * from user");
	}
	public void query(String sql){
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, user, pass);
			PreparedStatement t=(PreparedStatement) conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=t.executeQuery();
			{
				rs.last();
				int rowCount=rs.getRow();
				for(int i=rowCount;i>0;i--){
					//指针移动到此rs的给定行编号
					rs.absolute(i);
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				    //修改记录指针所指得记录，第2列的值
					rs.updateString(2, "我是小马"+i);
					//提交修改
					rs.updateRow();
				}
			}
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
