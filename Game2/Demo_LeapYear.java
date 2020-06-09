/**
判断闰年与平年
闰年规律：四年一闰，百年不闰。四百年再闰
*/
import java.util.Scanner;
class Demo_LeapYear{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入年份：");
		//存储了年份
		int year=in.nextInt();
		if(year%4==0&&year%100!=0||year%400==0){
			System.out.println(year+"   是闰年");
		}else{
			System.out.println(year+"   是平年");
		}
	}
}