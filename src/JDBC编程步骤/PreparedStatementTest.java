package JDBC编程步骤;
/**
 * 
 * 得出结论:Statement执行SQL语句时不允许使用问号占位符参数，而且这个问号占位符参数必须获得值后
 * 才可以执行。为了满足这种功能，JDBC提供了PreparedStatement接口，它是Statement接口的子
 * 接口，它可以预编译SQL语句，预编译之后的语句被存储在PreparedStatement对象中，然后可以使用
 * 该对象多次高效的执行语句，简而总之，使用PreparedStatement比使用Statement的效率要高。
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParams(String paramsFile) throws IOException, ClassNotFoundException{
		Properties ppt=new Properties();
		ppt.load(Properties.class.getResourceAsStream(paramsFile));
		driver=ppt.getProperty("driver");
		url=ppt.getProperty("url");
		user=ppt.getProperty("user");
		pass=ppt.getProperty("pass");
		//加载驱动
		Class.forName(driver);
	}
	
	public void insertBaseStatement() throws SQLException{
		long start=System.currentTimeMillis();
		Connection con=DriverManager.getConnection(url, user, pass);
		Statement s=con.createStatement();
		{
			for(int i=0;i<100;i++){
				s.executeUpdate("inser t into user values(null,'cmazxiaoma"+i+"','xiaoma')");
			}
			System.out.println("影响记录="+s.getUpdateCount()+",耗时="+(System.currentTimeMillis()-start));
		}
	}
	
	public void insertPrepareStatement() throws SQLException{
		long start=System.currentTimeMillis();
		Connection con=DriverManager.getConnection(url, user, pass);
		PreparedStatement pt=con.prepareStatement("insert into user values(null,?,?)");
		{
			for(int i=0;i<100;i++){
				pt.setString(1,"test"+i);
				pt.setString(2, "test"+i);
				pt.executeUpdate();
			}
			System.out.println("影响记录="+pt.getUpdateCount()+",耗时="+(System.currentTimeMillis()-start));
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		PreparedStatementTest s=new PreparedStatementTest();
		s.initParams("/mysql.properties");
		s.insertBaseStatement();
		s.insertPrepareStatement();
	}
	
	
	
	
	
	
	
	
	
	
}
