package day01taskServer;

import java.util.Scanner;

import day01taskDao.ARank;
import day01taskDao.BRank;
import day01taskDao.Operate;
import day01taskDao.Start;
import day01taskDomain.AdminUser;

public class UseServer {

	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int i=0;
		Integer control;
		Start sta1=new Start();
		Operate operate=new Operate();
		AdminUser sta2=sta1.denglu();
		if(sta2!=null){
			System.out.println("登录成功");
			System.out.println("欢迎你"+sta2.getRank()+"级员工");
			while(i==0){
				System.out.println("按1查询员工信息，按2增加员工,  按3删除员工，    按4更改员工信息");
				System.out.println("按5增加管理者    ，按6删除管理者，按7查询管理者，按8查看自身信息");
				System.out.println("按0退出");
				System.out.println("提示：由于使用的是1.6编译器请不要输入非数字参数，如使用1.6以上编译器建议改成String类型");
				control=input.nextInt();
				if(control==0){
					i=1;
				}else{
					operate.caozuo(sta2, control);
				}
			}
			
		}else{
			System.out.println("登录失败，帐号或密码错误");
		}
		
		

	}

}
