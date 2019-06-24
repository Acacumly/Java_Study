public class Course0624{
    public static void main(String[] args) {
        // write your code here
        //求1+2!+3!+4!+。。。50!=？
        //控制台输入阶乘的最大值：
        long temp = 1;
        long sum = 0;
        for (int i = 0; i < 3; i++) {//控制求和
            for (int k = 1; k <= i + 1; k++) {//控制阶乘
                temp = temp * k;//求每个数据阶乘
            }
            sum = sum + temp;//求和
        //重置临时变量temp
            temp = 1;
        }
        System.out.println(sum);//输出结果
    }

}