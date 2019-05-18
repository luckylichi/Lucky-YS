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
 * A��ֻ�����B������Ա��ɾ��B������Ա
 * s����A���ܶ� Ա������ɾ�Ĳ飬
 */
public class ARank extends BRank {
	//���B������Ա
	public void addBadmin(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Scanner input=new Scanner(System.in);
			System.out.println("�����˺�");
			String number = input.next();
			System.out.println("��������");
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
				System.out.println(temp+"�������Ѹ���");
			}else{
				System.out.println("��������ʧ��");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	//ɾ���û�
	public int delectEmp(){
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ�����û�ID");
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
				System.out.println(temp+"�������Ѹ���");
				System.out.println("ɾ���ɹ�");
				return id;
			}else{
				System.out.println("ɾ��ʧ��");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
		return -1;
	}
	
	
	//ɾ��B������Ա
	public void delectBadmin(){
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ����B������ԱID");
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
				System.out.println(temp+"�������Ѹ���");
				System.out.println("ɾ��B������Ա�ɹ�");
			}else{
				System.out.println("ɾ��B������Աʧ��");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	//��ѯB������Ա��Ϣ
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
	
	//����Ա����Ϣ
	public EmpUser updateEmp(){
			Connection conn = null;
			EmpUser user = new EmpUser();
			Scanner input = new Scanner(System.in);
			System.out.println("��������Ҫ���ĵ�Ա��ID");
			int id=input.nextInt();
			System.out.println("������Ա������");
			String name=input.next();
			System.out.println("������Ա������");
			int age=input.nextInt();
			System.out.println("������Ա���绰");
			String phone=input.next();
			System.out.println("������Ա������");
			String job=input.next();
			System.out.println("������Ա������");
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
					System.out.println(temp+"�������Ѹ���");
					System.out.println("�޸�Ա����Ϣ�ɹ�");
				}else{
					System.out.println("�޸�Ա����Ϣʧ��");
					
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
