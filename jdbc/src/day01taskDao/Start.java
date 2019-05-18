package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import day01task.C3P0;
import day01taskDomain.AdminUser;


public class Start {
	//登录
	public AdminUser denglu(){
		Connection conn = null;
		AdminUser adminuser=new AdminUser();
		try {
			conn=C3P0.getConn();
			String sql="select * from admin where number=? and psw=?";
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入帐号");
			String number=sc.next();
			System.out.println("请输入密码");
			String psw=sc.next();
			//创建PreparedStatement对象时，传入sql，进行预编译
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, number);
			ps.setString(2, psw);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				adminuser.setId(rs.getInt("id"));
				adminuser.setNumber(rs.getString("number"));
				adminuser.setPsw(rs.getString("psw"));
				adminuser.setRank(rs.getString("rank"));
				return adminuser;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
		return null;
	}

}
