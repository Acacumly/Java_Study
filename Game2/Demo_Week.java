/*
求某日的星期
公式：1900-1-1到该日的总天数%7=x
*/
import java.util.Scanner;
class Demo_Week{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入年份：");
		int inputYear=in.nextInt();
		System.out.println("请输入月份：");
		int inputMonth=in.nextInt();
		System.out.println("请输入日：");
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
					//闰年2月有29天
					monthSum+=29;
				}else{
					//平年2月有28天
					monthSum+=28;
				}
			}else if(month==1||month==3||month==5
||month==7||month==8||month==10||month==12){//1﹑3﹑5﹑7﹑8﹑10﹑12为大月
				//大月有31天
				monthSum+=31;
			}else{
				//小月有30天
				monthSum+=30;
			}	
		}
		monthSum+=inputDay;
		
		/*该日的星期*/
		int weekday=(monthSum+yearSum)%7;
		System.out.println(weekday);
	}
}