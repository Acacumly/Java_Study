/*
��ȭ��Ϸ
����A���û�
����B������

����(0)��ʯͷ(1)����(2)

���� KO ��
ʯͷ KO ����
�� KO ʯͷ

ʵ��˼·��
1.�û���ȭ
 487     `	 																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					2.������ȭ
3.������Ӯ
*/
import java.util.Scanner;
import java.util.Random;
class Game{
	public static void main(String[] args){
		System.out.println("���ȭ������(0)��ʯͷ(1)����(2)");
		Scanner in=new Scanner(System.in);
		//�����û���ȭ
		int user=in.nextInt();
		
		/**������ȭ*/
		Random random=new Random();
		//�������0��1��2��ֵ
		int computer=random.nextInt(3);
		if(user==0&&computer==2||user==1&&computer==0||user==2&&computer==1){
			System.out.println("��Ӯ��");
		}else if(user==computer){
			System.out.println("ƽ��");
		}else{
			System.out.println("������������");
		}
		//�洢�������û��ĳ�ȭ���
		String computerText="";
		String userText="";
		switch(user){
			case 0:
				userText="����";
				break;
			case 1:
				userText="ʯͷ";
				break;
			case 2:
				userText="��";
				break;
		}
		switch(computer){
			case 0:
				computerText="����";
				break;
			case 1:
				computerText="ʯͷ";
				break;
			case 2:
				computerText="��";
				break;
		}
		System.out.println("�û���"+userText+"	������"+computerText);
	}	
}