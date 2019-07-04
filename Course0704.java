import java.util.Scanner;
 public class Course0704 {
    public static void main(String [] args){
		int a, b, c;
		System.out.println("请输入三个正整数：");
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt(); 
		if(a <= 0 || b <= 0 || c <= 0)
		{
			System.out.println("输入的必须是正整数！");
		}
		if((a + b)> c &&(a + c) > b&&(b + c) > a)
		{
			System.out.println("能构成三角形！");
		}
		else{
			System.out.println("不能构成三角形！");
		}
	}
}