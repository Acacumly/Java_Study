import java.util.Random;
public class Course0705 {
    public static void panduan(int num){
        int b=num/100;      //百位数
        int s=num%100/10;   //十位数
        int g=num%10;       //个位数
        if(num%9==0){
            System.out.println(num+"能被9整除");
            if((b+s+g)%9==0){
                System.out.println("同时"+num+"的各个位数之和也能被9整除");
            }
            else{
                System.out.println("但是"+num+"的各个位数之和不能被9整除");
            }
        }
        else
            System.out.println("next test!");
         
    } 
    public static void main(String[] args) {
        Random rd=new Random();
        int shu=10+rd.nextInt(90);
        shu =shu *9;
        panduan(shu);
    }
}