/**
求1900年到2020年的总天数
步骤：
1.遍历1900-2020之间的年份
2.判断闰年与平年
3.累加各年份的总天数
*/
class Demo_TotalDays{
	public static void main(String[] args){
		int sum=0;
		for(int year=1900;year<=2020;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				sum=sum+366;
			}else{
				sum=sum+365;
			}
		}
		System.out.println(sum);
	}
}