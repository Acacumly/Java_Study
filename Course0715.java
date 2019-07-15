import java.util.Scanner;
import java.util.Arrays;
public class Course0715 {
	public static void main(String[] args) {
		System.out.println("输入一个十个数的数组：");
		Scanner scanner = new Scanner(System.in);
		int n = 10;
		int[]arrA = new int[n];
		for (int i = 0; i < n; i++) {
			arrA[i] = scanner.nextInt();//获取十个数组
		}
		System.out.println("没移动前的数组：" + Arrays.toString(arrA));
		System.out.println("请输入要往后移动的个数：");
		int m = scanner.nextInt();//获取输入往后退的个数
		m %= n;//十个相当于循环
		int[]arrB=new int[n];//创建和数组A大小一样的数组B
		int k = m;//创建一个可变的变量
		for (int i = m; i < arrA.length; i++) {
			arrB[i] = arrA[i-m];
		} 
		for (int i = 0; i < m; i++) {
			arrB[i]=arrA[arrA.length-k];
			k--;
		}
		System.out.println("移动后的数组："+Arrays.toString(arrB));//输出数组B
		scanner.close();
	}
}
