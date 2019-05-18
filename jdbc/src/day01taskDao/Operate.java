package day01taskDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import day01task.C3P0;
import day01taskDomain.AdminUser;
import day01taskDomain.EmpUser;

public class Operate {
	//		System.out.println("按1查询员工信息，按2增加员工,  按3删除员工，    按4更改员工信息");
//		System.out.println("按5增加管理者    ，按6删除管理者，按7查询管理者，按8查看自身信息");
//		System.out.println("按0退出");
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
			System.out.println("对不起你的权限不够");
			
			break;
		case 4:
			System.out.println("对不起你的权限不够");
			
			break;
		case 5:
			System.out.println("对不起你的权限不够");
			break;
		case 6:
			System.out.println("对不起你的权限不够");

			break;
		case 7:
			System.out.println("对不起你的权限不够");

			break;
		case 8:
			System.out.println(adm.toString());
			break;
			

		default:
			System.out.println("输入有误");
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
				System.out.println("输入有误");
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
				System.out.println("输入有误");
				break;
			}
			
			
			
			
			
			
			
			
		}else{
			System.out.println("你的等级信息有误，请联系A级及以上管理员更改");
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
	
	
	//历史数据
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
				System.out.println(temp+"行数据已更新");
				System.out.println("员工历史表修改成功");
			}else{
				System.out.println("插入数据失败");
				System.out.println("员工历史表修改失败");
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0.close(conn);
		}
	
	}
	
	}
	
	
