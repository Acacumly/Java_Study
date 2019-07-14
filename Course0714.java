import java.util.Scanner;
public class Course0714 {
    public static void main(String[] args) {
		System.out.println("三个整数：");
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();//获取整数
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int temp = 0;//最为一个交换数
		if (num1 > num2) {//保证num2>num1
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1 > num3) {//保证num3>num1
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if (num2 > num3) {//保证num3>num2
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.println("这三个数从小到大排列：" + num1 + "  " + num2 + "  " + num3);
		scanner.close();
	}
}
