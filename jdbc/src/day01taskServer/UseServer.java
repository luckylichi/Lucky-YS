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
			System.out.println("��¼�ɹ�");
			System.out.println("��ӭ��"+sta2.getRank()+"��Ա��");
			while(i==0){
				System.out.println("��1��ѯԱ����Ϣ����2����Ա��,  ��3ɾ��Ա����    ��4����Ա����Ϣ");
				System.out.println("��5���ӹ�����    ����6ɾ�������ߣ���7��ѯ�����ߣ���8�鿴������Ϣ");
				System.out.println("��0�˳�");
				System.out.println("��ʾ������ʹ�õ���1.6�������벻Ҫ��������ֲ�������ʹ��1.6���ϱ���������ĳ�String����");
				control=input.nextInt();
				if(control==0){
					i=1;
				}else{
					operate.caozuo(sta2, control);
				}
			}
			
		}else{
			System.out.println("��¼ʧ�ܣ��ʺŻ��������");
		}
		
		

	}

}
