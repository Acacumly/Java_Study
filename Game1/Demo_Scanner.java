import java.util.Scanner;
class Demo_Scanner{
	public static void main(String[] args){
		System.out.println("****���Ǽӷ�������****");
		System.out.println("�������һ��ֵ��");
		//����Scanner���͵ı���������ֵ
		Scanner in=new Scanner(System.in);
		//��ȡ�û������룬��������ݱ�����int����
		int a=in.nextInt();
		System.out.println("������ڶ���ֵ��");
		int b=in.nextInt();
		int result=a+b;
		System.out.println(a+"+"+b+"="+result);
		System.out.println("����");
	}
}