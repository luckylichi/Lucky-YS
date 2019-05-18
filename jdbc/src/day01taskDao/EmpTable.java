package day01taskDao;

import java.sql.Connection;
import java.sql.Statement;

import day01task.C3P0;

public class EmpTable {
	//创建emp表
	public static void createEmpTable(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Statement st = conn.createStatement();
			String sql="create table emp(id int(4) PRIMARY KEY AUTO_INCREMENT not null,name char(20)  not null,age char(3) not null,phone char(13) not null,salary double(7,2) not null)";
			boolean boo = st.execute(sql);
			System.out.println("执行结果："+boo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
		
	}
	
	//删除emp表
	public static void dropEmpTable(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Statement st = conn.createStatement();
			String sql="drop table emp";
			boolean boo = st.execute(sql);
			System.out.println("执行结果："+boo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
		
	}

}
