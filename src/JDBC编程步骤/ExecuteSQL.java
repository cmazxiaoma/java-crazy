package JDBC编程步骤;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteSQL {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public static void main(String[] args) throws IOException, SQLException{
		ExecuteSQL es=new ExecuteSQL();
		es.initParams("/mysql.properties");
		System.out.println("-----遍历-----");
		es.executeSql("select * from user");
		System.out.println("-----添加-----");
		es.executeSql("insert into user values(null,'cmazxiaoam1','cmazxiaomatest1')");
		System.out.println("-----删除------");
		es.executeSql("drop table user");
		
	}
	
	public void initParams(String paramsFile) throws IOException{
		Properties ppt=new Properties();
		ppt.load(Properties.class.getResourceAsStream(paramsFile));
		driver=ppt.getProperty("driver");
		url=ppt.getProperty("url");
		user=ppt.getProperty("user");
		pass=ppt.getProperty("pass");
	}
	
	public void executeSql(String sql) throws SQLException{
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement t=con.createStatement();
			{
				boolean hasResultSet=t.execute(sql);
				if(hasResultSet){
					//结果集
					ResultSet rs=t.getResultSet();
					//ResultSetMetaData是用于分析结果集的元接口
					ResultSetMetaData rsmd=rs.getMetaData();
					int columnCount=rsmd.getColumnCount();
					while(rs.next()){
						for(int i=0;i<columnCount;i++){
							System.out.printf(rs.getString(i+1)+",");
						}
						System.out.printf("\n");
					}
				}else{
					System.out.println("该SQL语句影响的记录="+t.getUpdateCount());
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
