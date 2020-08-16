package lesson4;

public class Sington {

    // 恶汉式
    private static final Sington SINGTON = new Sington();
    public static Sington getInstance(){
        return SINGTON;
    }

    // 懒汉
    private volatile static Sington SINGTON2 = null;
    public static Sington getInstance2(){
        //多个线程可以同时进入这行代码进行判断，都判断为null
        if(SINGTON2 == null){
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }

    // synchronized第一种写法
    public synchronized static Sington getInstance3(){
//        synchronized (Sington.class){
//
//        }
        //多个线程可以同时进入这行代码进行判断，都判断为null
        if(SINGTON2 == null){
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }

    // synchronized第二种写法
    public static Sington getInstance4(){
        if(SINGTON2 == null){
            synchronized (Sington.class){
                if(SINGTON2 == null){
                    SINGTON2 = new Sington();
                }
            }
        }
        return SINGTON2;
    }

    private Sington(){
        // nothing to do
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sington.getInstance2();
                }
            }).start();
        }
    }
}
