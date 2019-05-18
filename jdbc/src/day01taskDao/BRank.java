package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import day01task.C3P0;
import day01taskDomain.EmpUser;

public class BRank {
	
	//查询
	public void check(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Statement st =  conn.createStatement();
			String sql = "select * from emp";
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				
				EmpUser user =new EmpUser();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setPhone(rs.getString("phone"));
				user.setJob(rs.getString("job"));
				user.setSalary(rs.getDouble("salary"));
				System.out.println(user.toString());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	
	//增加
	public EmpUser add(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Scanner input=new Scanner(System.in);
			System.out.println("输入名字");
			String name = input.next();
			System.out.println("输入年龄");
			int age =input.nextInt();
			System.out.println("输入电话");
			String phone = input.next();
			System.out.println("输入工作");
			String job = input.next();
			System.out.println("输入工资");
			double salary = input.nextDouble();
			
			String sql = "insert into emp values(null,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, phone);
			ps.setString(4, job);
			ps.setDouble(5, salary);
			ps.addBatch();
			
			System.out.println(sql);
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"行数据已更新");
			}else{
				System.out.println("插入数据失败");
				
			}
			
		
			String sql1 = "select * from emp";
			Statement st =  conn.createStatement();
			ResultSet rs=st.executeQuery(sql1);
			EmpUser user =new EmpUser();
			while(rs.next()){
				
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setPhone(rs.getString("phone"));
				user.setJob(rs.getString("job"));
				user.setSalary(rs.getDouble("salary"));
				
			
			}
			return user;
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
		return null;
	}
	public static void main(String[] args) {
		BRank b=new BRank();
		b.add();
	}

	
	
}
