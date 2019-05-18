package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import day01task.C3P0;
import day01taskDomain.AdminUser;

public class SRank extends ARank{
	//ɾ������Ա
	public void delectAllAdmin(){
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ���Ĺ���ԱID");
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
				System.out.println(temp+"�������Ѹ���");
				System.out.println("ɾ������Ա�ɹ�");
			}else{
				System.out.println("ɾ������Աʧ��");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	
	//��ӹ���Ա
	public void addAllAdmin(){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			Scanner input=new Scanner(System.in);
			System.out.println("������ӵĹ���Ա�˺�");
			String number = input.next();
			System.out.println("������ӵĹ���Ա����");
			String pwd = input.next();
			System.out.println("������ӵĹ���Ա�ȼ�S,A,B�е�һ��");
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
				System.out.println(temp+"�������Ѹ���,"+rank+"������Ա��ӳɹ�");
			}else{
				System.out.println("��ӹ���Աʧ��");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	}
	
	
	
	//��ѯ���й�������Ϣ
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

