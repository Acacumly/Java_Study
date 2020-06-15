import java.util.Scanner;
class Demo_Scanner {
    public static void main(String[] args) {
        System.out.println("******我是加法计算器******");
        System.out.println("请输入第一个值: ");
        //定义Scanner类型的变量, 并赋值
        Scanner in = new Scanner(System.in) ;
        //获取用户的输入,输入的数据必须是int类型
        int a = in.nextInt();
        System.out.println("请输入第二个值: ");
        int b = in.nextInt();
        int result = a + b;
        System.out.println(a+ "+" +b+ "=" +result);
        System.out.println("结束");
    }
}
