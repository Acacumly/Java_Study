public class Course0711 {
    public static boolean isyinzi(int num ){
        int sum = 0;
        //判断一个整数是不是一个完全数
        for(int d = num-1;d >= 1;d--){
            if(num%d == 0){
                sum += d;
            }
        }
        return sum == num;
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         * 编程求1~1000之间的所有“完全数”，
         * 完全数是该数的所有因子之和等
         * 于该数的数。例如，6的因子有1、2、3，
         * 且6=1+2+3，所以6是完全数*/
        for(int a = 1;a <= 1000;a++){
            int num = a;
            if(isyinzi(num)){
                System.out.println(num);
            }
        }
 
    }
 
}