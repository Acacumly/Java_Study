/**
��1900-01-01��2020-09-07��������
���裺
1.��1900-01-01��2019��12-31��������
2.��2020-01-01��2020-09-07��������
3.�������
*/
class Demo_TotalDays2{
	public static void main(String[] args){
		/*��1900-01-01��2019��12-31��������*/	
		int yearSum=0;
		for(int year=1900;year<=2019;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				yearSum+=366;
			}else{
				yearSum+=365;
			}
		}
		/*��2020-01-01��2020-09-07��������*/
		int monthSum=0;
		for(int month=1;month<=8;month++){
			if(month==2){
				if(2020%4==0&&2020%100!=0||2020%400==0){
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
		monthSum+=7;
		
		/*�������*/
		System.out.println(monthSum+yearSum);
	}
}