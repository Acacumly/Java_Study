public class Course0710 {
    public static void main(String[] args) {
        for(int num=100;num<1000;num++){
            if(isshuixian(num)){
                System.out.println(num);
            }
        }
    }
    //判断一个数是不是水仙花数
    public static boolean isshuixian(int num){
        int b=num/100;
        int s=num%100/10;
        int g=num%10;
        return Math.pow(b, 3)
                +Math.pow(s, 3)
                +Math.pow(g, 3)==num?true:false;
    }
}