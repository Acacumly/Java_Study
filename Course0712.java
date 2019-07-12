import java.util.Scanner;
public class Course0712 {
	public static void main(String[] args) {
		int bigDivisor = 0;//定义最大公约数
		int multiple = 0;//定义最小公倍数
		System.out.println("请输入两个整数：");
		Scanner scanner = new Scanner(System.in);
		int input1 = scanner.nextInt();//获取第一个数
		int input2 = scanner.nextInt();//获取第二个数
		multiple = input1 * input2;//这个值保存，求公约数后，方便求得最小公倍数
		int temp = 1;// 交换用的中间数
		if (input2 > input1) {//确保第一个数不小于第二个数
			temp = input1;
			input1 = input2;
			input2 = temp;
		}
		while (temp != 0) { //求余结果不等于零，就一直循环
			temp = input1 % input2;//求余结果
			input1 = input2;//大的数已经没用了，用小的数替代
			input2 = temp;//把求余的结果赋值给小的数
	   }
		bigDivisor = input1;//最后一次求余结果为零时，被求余的数
		multiple = multiple/bigDivisor;
		System.out.println("最大公约数是：" + bigDivisor );
		System.out.println("最小公倍数是：" + multiple);    
		scanner.close();
	}
}