import java.util.Scanner;
public class Course0709 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner sc=new Scanner(System.in); 
        int num=sc.nextInt();
        System.out.println(num+"的质因数有：");
        for(int i=2;i<num;i++){
            while(num%i==0){
                num/=i;
                System.out.print(i+" ");
            }
        }
        System.out.print("  "+num);
    }
 
}