package day01task;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
	public static  String driver;
	public static  String name;
	public static  String pwd;
	public static  String url;
	public static  String maxActive;
	public static  String initialSize;
	public static  String maxWait;
	public static  String minIdle;
	private static ComboPooledDataSource ds;
	
	static{
		try {
			Properties pro =new Properties();
			//输入流
			InputStream ips = C3P0.class.getClassLoader().getResourceAsStream("config/db.properties");
			pro.load(ips);
			ips.close();
			
			driver = pro.getProperty("mysqldriver");
			url = pro.getProperty("mysqlurl");
			name = pro.getProperty("mysqlname");
			pwd = pro.getProperty("pwd");
			maxActive = pro.getProperty("maxactive");
			initialSize = pro.getProperty("initialsize");
			maxWait = pro.getProperty("maxwait");
			minIdle = pro.getProperty("minidle");
			

			ds = new ComboPooledDataSource();
			//进行连接
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(name);
			ds.setPassword(pwd);
			System.out.println("连接成功");
			
			
			ds.setMaxPoolSize(Integer.valueOf(maxActive));
			ds.setInitialPoolSize(Integer.valueOf(initialSize));
			ds.setCheckoutTimeout(Integer.valueOf(maxWait));
			ds.setMinPoolSize(Integer.valueOf(minIdle));
			System.out.println("连接参数设置完成");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn() throws SQLException{
		return C3P0.ds.getConnection();
	}
	
	//关闭数据库
	public static void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
			System.out.println("连接已归还");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
