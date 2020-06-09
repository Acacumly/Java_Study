/**
求1900-01-01到2020-09-07的总天数
步骤：
1.求1900-01-01到2019年12-31的总天数
2.求2020-01-01到2020-09-07的总天数
3.两者相加
*/
class Demo_TotalDays2{
	public static void main(String[] args){
		/*求1900-01-01到2019年12-31的总天数*/	
		int yearSum=0;
		for(int year=1900;year<=2019;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				yearSum+=366;
			}else{
				yearSum+=365;
			}
		}
		/*求2020-01-01到2020-09-07的总天数*/
		int monthSum=0;
		for(int month=1;month<=8;month++){
			if(month==2){
				if(2020%4==0&&2020%100!=0||2020%400==0){
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
		monthSum+=7;
		
		/*两者相加*/
		System.out.println(monthSum+yearSum);
	}
}