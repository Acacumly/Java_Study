/*
��ĳ�յ�����
��ʽ��1900-1-1�����յ�������%7=x
*/
import java.util.Scanner;
class Demo_Week{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("��������ݣ�");
		int inputYear=in.nextInt();
		System.out.println("�������·ݣ�");
		int inputMonth=in.nextInt();
		System.out.println("�������գ�");
		int inputDay=in.nextInt();

		int yearSum=0;
		for(int year=1900;year<=inputYear-1;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				yearSum+=366;
			}else{
				yearSum+=365;
			}
		}
		
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
		monthSum+=inputDay;
		
		/*���յ�����*/
		int weekday=(monthSum+yearSum)%7;
		System.out.println(weekday);
	}
}