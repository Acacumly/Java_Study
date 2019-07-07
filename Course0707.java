import java.util.Scanner;
public class Course0707 {
    public static void main(String[] args) {
        //小写字母的ascll值为97-122
        //大写字母的ascll值为65-90
        System.out.println("请输入一个字母：\n");
        Scanner input = new Scanner(System.in);
        char zimu=input.next().charAt(0);
          if (zimu>=97&&zimu<=122){           //判断是否是小写字母
              System.err.println("该字母是小写字母");
              zimu=(char) (zimu-32);        //如果是小写字母则 将其转换成大写字母
              System.err.println("转换之后的大写字母是："+zimu);
          } 
          else{
             System.out.println("该字母不是小写字母！");           
          }
    }   
}