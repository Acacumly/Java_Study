import java.util.Scanner;
 
public class Course0703 {
	public static void main(String[]args){
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int read = sc.nextInt();
        //方法一     reverse()API
		System.out.println("方法一：");
        StringBuilder sb  =  new StringBuilder(String.valueOf(read));
        System.out.println(sb.reverse());
        //方法二   将字符串转换成字符数组，反序输出
        String str= read +"";
        char fuzu[]=str.toCharArray();
        String temp="";
        for(int a=fuzu.length-1;a>=0;a--){
            temp=temp+fuzu[a];
        }
        System.out.println("方法二：");
        System.out.println(temp);     
	}
}