/*
����

ʵ�ֲ��裺
1.���ܿ���̨�����������·�
2.��ӡ������


\t ��ʾһ���Ʊ����7���ո�
*/
import java.util.Scanner;
class MyCalendar{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("��������ݣ�");
		int inputYear=in.nextInt();
		System.out.println("�������·ݣ�");
		int inputMonth=in.nextInt();
		
		//����ݵ�������
		int yearSum=0;
		for(int year=1900;year<=inputYear-1;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				yearSum+=366;
			}else{
				yearSum+=365;
			}
		}
		//���·ݵ�������
		int monthSum=0;
		for(int month=1;month<=inputMonth-1;month++){
			if(month==2){
				if(inputYear%4==0&&inputYear%100!=0||inputYear%400==0){
					//����2����29��
					monthSum+=29;
				}else{
					//ƽ��2����28��
					monthSum+=28;
				}
			}else if(month==1||month==3||month==5
||month==7||month==8||month==10||month==12){//1�p3�p5�p7�p8�p10�p12Ϊ����
				//������31��
				monthSum+=31;
			}else{
				//С����30��
				monthSum+=30;
			}	
		}
		//�����루�·�-1���µ����һ�վ���1900-1-1�ŵ�������
		int sum=monthSum+yearSum;
		/*����1�ŵ�����*/
		int weekday=(sum+1)%7;
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		//��ӡ����Ʊ����ʹ����1���ܹ�������ȷ����������
		for(int i=1;i<=weekday;i++){
			System.out.print("\t");
		}

		//��������ж�����
		int dayCount=0;
		switch(inputMonth){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				 dayCount=31;
				 break;
			case 4:case 6:case 9:case 11:
				dayCount=30;
				break;
			case 2:
				if(inputYear%4==0&&inputYear%100!=0||inputYear%400==0){
					//����2����29��
					dayCount=29;
				}else{
					//ƽ��2����28��
					dayCount=28;
				}
				break;
		}
		
		//��ӡ�·ݵ�������
		for(int i=1;i<=dayCount;i++){
			System.out.print(i+"\t");
			if((sum+i)%7==6){
				System.out.println();
			}
		}
	}
}