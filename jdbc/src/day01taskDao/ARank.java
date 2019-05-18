package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import day01task.C3P0;
import day01taskDomain.AdminUser;
import day01taskDomain.EmpUser;

/*
 * A级只能添加B级管理员和删除B级管理员
 * s级和A级能对 员工表增删改查，
 */
public class ARank extends BRank {
	//添加B级管理员
	public void addBadmin(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Scanner input=new Scanner(System.in);
			System.out.println("输入账号");
			String number = input.next();
			System.out.println("输入密码");
			String pwd = input.next();
			
			String sql = "insert into admin values(null,?,?,'B')";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, number);
//			ps.setString(2, );
			ps.setString(2, pwd);
//			ps.setString(4, "");
			ps.addBatch();
			System.out.println(sql);
		
//			st.executeUpdate(sql);
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"行数据已更新");
			}else{
				System.out.println("插入数据失败");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	//删除用户
	public int delectEmp(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的用户ID");
		int id=input.nextInt();
		Connection conn = null;
		try {
			conn=C3P0.getConn();
			String sql="delete from emp where id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.addBatch();
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"行数据已更新");
				System.out.println("删除成功");
				return id;
			}else{
				System.out.println("删除失败");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
		return -1;
	}
	
	
	//删除B级管理员
	public void delectBadmin(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的B级管理员ID");
		int id=input.nextInt();
		Connection conn = null;
		try {
			conn=C3P0.getConn();
			String sql="delete from admin where id=? and rank='B' ";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.addBatch();
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"行数据已更新");
				System.out.println("删除B级管理员成功");
			}else{
				System.out.println("删除B级管理员失败");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	//查询B级管理员信息
	public void checkBadmin(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Statement st =  conn.createStatement();
			String sql = "select * from admin where rank='B' ";
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				AdminUser user =new AdminUser();
				user.setId(rs.getInt("id"));
				user.setNumber(rs.getString("number"));
				user.setPsw(rs.getString("psw"));
				user.setRank(rs.getString("rank"));
				System.out.println(user.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	//更改员工信息
	public EmpUser updateEmp(){
			Connection conn = null;
			EmpUser user = new EmpUser();
			Scanner input = new Scanner(System.in);
			System.out.println("请输入需要更改的员工ID");
			int id=input.nextInt();
			System.out.println("请输入员工姓名");
			String name=input.next();
			System.out.println("请输入员工年龄");
			int age=input.nextInt();
			System.out.println("请输入员工电话");
			String phone=input.next();
			System.out.println("请输入员工工作");
			String job=input.next();
			System.out.println("请输入员工工资");
			double salary=input.nextDouble();
			try {
				conn=C3P0.getConn();
				
				String sql1 = "select * from emp where id=? ";
				PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(sql1);
				ps1.setInt(1, id);
				ps1.addBatch();
				ResultSet rs=ps1.executeQuery();
				while(rs.next()){
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setAge(rs.getInt("age"));
					user.setPhone(rs.getString("phone"));
					user.setJob(rs.getString("job"));
					user.setSalary(rs.getDouble("salary"));
				}
				
				
				
				String sql="update emp set name=?, age=?, phone=?, job=?, salary=? where id=? ";
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, phone);
				ps.setString(4, job);
				ps.setDouble(5, salary);
				ps.setInt(6, id);
				ps.addBatch();
				int temp=ps.executeUpdate();
				
				if(temp>0){
					System.out.println(temp+"行数据已更新");
					System.out.println("修改员工信息成功");
				}else{
					System.out.println("修改员工信息失败");
					
				}
				return user;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				C3P0.close(conn);
			}
			return null;
		}

}
