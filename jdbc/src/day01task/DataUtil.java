//package day01task;
//
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.Properties;
//
//
//public class DataUtil {
//	public static String driver;
//	public static String url;
//	public static String name;
//	public static String pwd;
//		
//	public static Connection getConn() throws Exception{
//		Connection conn = null;
//		
//		try {
//			Properties pro=new Properties();
//			InputStream ips=DataUtil.class.getClassLoader().getResourceAsStream("config/db.properties");
//			pro.load(ips);
//			ips.close();
//		
//			driver=pro.getProperty("mysqldriver");
//			url=pro.getProperty("mysqlurl");
//			name=pro.getProperty("mysqlname");
//			pwd=pro.getProperty("pwd");
//			
//			
//			Class.forName(driver);
//			conn =  DriverManager.getConnection(url,name,pwd);
//			System.out.println("获取数据库成功");
//			return conn;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			//如果获取连接出现异常
//			//那么我们将异常信息，抛出给调用者
//			throw e;
//		}
//		
//	}
//	
//	public static void close(Connection conn){
//		try {
//			if(conn!=null){
//				conn.close();
//				System.out.println("数据库关闭成功");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//
//}
