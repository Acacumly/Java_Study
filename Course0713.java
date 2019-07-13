import java.util.Scanner;
public class Course0713 {
	public static void main(String[] args) {
		int num = 0;//数字的个数
		int letter = 0;//字母的个数
		int space = 0;//空格的个数
		int others = 0;//其他的个数
		System.out.println("请输入一串字符：");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();//获取一行字符串
		//把字符串里面的值赋值给一个字符型数组
		char[] arr = string.toCharArray();
		//遍历字符串里面的所有值
		for (int i = 0; i < arr.length; i++) {       
			if (arr[i] >= 48 && arr[i] <= 57) {//字符是数字
				num++;
		} else if((arr[i] >= 65 && arr[i] <= 90)||(arr[i] >= 97 && arr[i] <= 122)) {
				letter++;
			}else if (arr[i] == 32) {
			  space++;
			}else {
				others++;
			}
		}
	   System.out.println("数字："+num+"个，字母："+letter+"个，空格："+space+"个，其他："+others+"个");         
	   scanner.close();
	}
}