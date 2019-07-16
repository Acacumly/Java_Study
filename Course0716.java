import java.util.Scanner;
 public class Course0716 {
    static int number = 4;        //输入4个数存放在数组中                    
    static int[] t1 = new int[number];            
    public static void main(String[] args) {
        Course0716 number = new Course0716();
        number.shunxun();
    }
    void shunxun(){
                System.out.println("请输入4个数：");
                Scanner in_t1 = new Scanner(System.in);//循环输入数组
                for(int i = 0; i < number;i++){
                    t1[i] = in_t1.nextInt();}        
                for (int i = 0; i < t1.length; i++) {
                    int pos = i;
                    for (int j = i + 1; j < t1.length; j++) {
                        if (t1[pos] > t1[j])
                            pos = j;
                    }
                    if (pos != i) {
                        t1[i] = t1[i] + t1[pos];
                        t1[pos] = t1[i] - t1[pos];
                        t1[i] = t1[i] - t1[pos];
                    }
                }  
                for (int i = t1.length - 1; i >= 0; i--)
                    System.out.print(t1[i] + "\t");
    }
}