/*
日历

实现步骤：
1.接受控制台输入的年份与月份
2.打印各星期


\t 表示一个制表符（7个空格）
*/
import java.util.Scanner;
class MyCalendar{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入年份：");
		int inputYear=in.nextInt();
		System.out.println("请输入月份：");
		int inputMonth=in.nextInt();
		
		//求年份的总天数
		int yearSum=0;
		for(int year=1900;year<=inputYear-1;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				yearSum+=366;
			}else{
				yearSum+=365;
			}
		}
		//求月份的总天数
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
		//所输入（月份-1）月底最后一日距离1900-1-1号的总天数
		int sum=monthSum+yearSum;
		/*该月1号的星期*/
		int weekday=(sum+1)%7;
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		//打印多个制表符，使该月1号能够放在正确的星期下面
		for(int i=1;i<=weekday;i++){
			System.out.print("\t");
		}

		//计算该月有多少天
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
					//闰年2月有29天
					dayCount=29;
				}else{
					//平年2月有28天
					dayCount=28;
				}
				break;
		}
		
		//打印月份的所有日
		for(int i=1;i<=dayCount;i++){
			System.out.print(i+"\t");
			if((sum+i)%7==6){
				System.out.println();
			}
		}
	}
}