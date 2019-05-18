package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import day01task.C3P0;
import day01taskDomain.AdminUser;

public class SRank extends ARank{
	//删除管理员
	public void delectAllAdmin(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的管理员ID");
		int id=input.nextInt();
		Connection conn = null;
		try {
			conn=C3P0.getConn();
			String sql="delete from admin where id=? ";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.addBatch();
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"行数据已更新");
				System.out.println("删除管理员成功");
			}else{
				System.out.println("删除管理员失败");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	
	//添加管理员
	public void addAllAdmin(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Scanner input=new Scanner(System.in);
			System.out.println("输入添加的管理员账号");
			String number = input.next();
			System.out.println("输入添加的管理员密码");
			String pwd = input.next();
			System.out.println("输入添加的管理员等级S,A,B中的一个");
			String rank = input.next();
			
			String sql = "insert into admin values(null,?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, number);
//			ps.setString(2, );
			ps.setString(2, pwd);
			ps.setString(3, rank);
			ps.addBatch();
			System.out.println(sql);
		
//			st.executeUpdate(sql);
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"行数据已更新,"+rank+"级管理员添加成功");
			}else{
				System.out.println("添加管理员失败");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	
	
	//查询所有管理者信息
	public void checkAllAdmin(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Statement st =  conn.createStatement();
			String sql = "select * from admin";
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				
				AdminUser adminuser1=new AdminUser();
				adminuser1.setId(rs.getInt("id"));
				adminuser1.setNumber(rs.getString("number"));
				adminuser1.setPsw(rs.getString("psw"));
				adminuser1.setRank(rs.getString("rank"));
				System.out.println(adminuser1.toString());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	}

