import java.util.Scanner;
public class Course0717
//△=b^2-4ac的值,若△小于0,一元二次方程无根.若△等于0,一元二次方程有两个相等的根.若△大于0,一元二次方程有两个不相等的实数根
    {
    public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("输入2次方的系数");
    int a = sc.nextInt();
    System.out.println("输入1次方的系数");
    int b = sc.nextInt();
    System.out.println("输入0次方的系数");
    int c = sc.nextInt();
    if((b*b - 4*a*c)<0){     //  判断方程是否有解
        System.out.println("方程无解！");
        return;
    }
    else{
        System.out.println("方程有解！");
    }
    double x1 = (-b + Math.sqrt(b*b - 4*a*c))/2*a;
    double x2 = (-b - Math.sqrt(b*b - 4*a*c))/2*a;
    System.out.println("根分别是 " + x1 + "\t" + x2);
    }
}