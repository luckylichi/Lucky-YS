package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import day01task.C3P0;
import day01taskDomain.AdminUser;
import day01taskDomain.EmpUser;

public class Operate {
	//		System.out.println("��1��ѯԱ����Ϣ����2����Ա��,  ��3ɾ��Ա����    ��4����Ա����Ϣ");
//		System.out.println("��5���ӹ�����    ����6ɾ�������ߣ���7��ѯ�����ߣ���8�鿴������Ϣ");
//		System.out.println("��0�˳�");
	public void caozuo(AdminUser adm,int control){
		BRank brank=new BRank();
		ARank arank=new ARank();
		SRank srank=new SRank();
		EmpUser empuser;
		int id;
		Operate operate=new Operate();
		if("B".equals(adm.getRank())){
		switch (control) {

		
		
		
		
		
		
		
		case 1:
			brank.check();
			break;
		case 2:
			empuser= brank.add();
//			System.out.println(empuser.getId());
			if(empuser!=null){operate.ChangRecall(adm,"Add", empuser.getId());}
			
			break;
		case 3:
			System.out.println("�Բ������Ȩ�޲���");
			
			break;
		case 4:
			System.out.println("�Բ������Ȩ�޲���");
			
			break;
		case 5:
			System.out.println("�Բ������Ȩ�޲���");
			break;
		case 6:
			System.out.println("�Բ������Ȩ�޲���");

			break;
		case 7:
			System.out.println("�Բ������Ȩ�޲���");

			break;
		case 8:
			System.out.println(adm.toString());
			break;
			

		default:
			System.out.println("��������");
			break;
		}
		}else if("A".equals(adm.getRank())){
			
			
			
			
			
			
			
			
			
			switch (control) {

			case 1:
				arank.check();
				break;
			case 2:
				empuser= arank.add();
//				System.out.println(empuser.getId());
				if(empuser!=null){operate.ChangRecall(adm,"Add", empuser.getId());}
				
				break;
			case 3:
				id = arank.delectEmp();
				if(id!=-1){operate.ChangRecall(adm,"Delete", id );}
				
				break;
			case 4:
				empuser = arank.updateEmp();
				
				if(empuser!=null){
					operate.addEmpHis(empuser);
				operate.ChangRecall(adm,"Update",  empuser.getId());
				}
				
				break;
			case 5:
				arank.addBadmin();
				break;
			case 6:
				arank.delectBadmin();
				break;
			case 7:
				arank.checkBadmin();
				break;
			case 8:
				System.out.println(adm.toString());
				break;
				

			default:
				System.out.println("��������");
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
		}else if("S".equals(adm.getRank())){
			
			
			
			
			
			
			
			switch (control) {

			case 1:
				srank.check();
				break;
			case 2:
				empuser=srank.add();
//				System.out.println(empuser.getId());
				if(empuser!=null){operate.ChangRecall(adm,"Add", empuser.getId());}
				
				break;
			case 3:
				id = srank.delectEmp();
				if(id!=-1){operate.ChangRecall(adm,"Delete", id );}
				
				break;
			case 4:
				empuser = srank.updateEmp();
				
				if(empuser!=null){
					operate.addEmpHis(empuser);
				operate.ChangRecall(adm,"Update",  empuser.getId());
				}
				
				break;
			case 5:
				srank.addAllAdmin();
				break;
			case 6:
				srank.delectAllAdmin();
				break;
			case 7:
				srank.checkAllAdmin();
				break;
			case 8:
				System.out.println(adm.toString());
				break;
				

			default:
				System.out.println("��������");
				break;
			}
			
			
			
			
			
			
			
			
		}else{
			System.out.println("��ĵȼ���Ϣ��������ϵA�������Ϲ���Ա����");
		}
	}
	
	
	public void ChangRecall(AdminUser adm,String use,int id){
		Connection conn=null;
		try {
			conn=C3P0.getConn();
			
			String sql = "insert into changuse values(null,?,?,?,?,null)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, adm.getNumber());
			ps.setString(2, adm.getRank());
			ps.setString(3, use);
			ps.setInt(4, id);
			ps.addBatch();
			
			System.out.println(sql);
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
	
	
	//��ʷ����
	public void addEmpHis(EmpUser empuser){
		Connection conn=null;
		try {
			conn=C3P0.getConn();

			String sql = "insert into emphis values(?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, empuser.getId());
			ps.setString(2, empuser.getName());
			ps.setInt(3, empuser.getAge());
			ps.setString(4, empuser.getPhone());
			ps.setString(5, empuser.getJob());
			ps.setDouble(6, empuser.getSalary());
			ps.addBatch();
			System.out.println(sql);
		
			int temp=ps.executeUpdate();
			
			if(temp>0){
				System.out.println(temp+"�������Ѹ���");
				System.out.println("Ա����ʷ���޸ĳɹ�");
			}else{
				System.out.println("��������ʧ��");
				System.out.println("Ա����ʷ���޸�ʧ��");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	
	}
	
	}
	
	
