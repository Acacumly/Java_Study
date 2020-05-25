package lesson4;

import java.util.ArrayList;
import java.util.List;

public class SafeThread {

    public static int COUNT;  //静态变量命名：全大写

    public static void main(String[] args) {
        //开启20个线程，每个线程对COUNT进行++操作10000次
        //预期结果200000
        for (int x = 0; x < 20; x++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
//                        COUNT++;
                        increment();
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(COUNT);

    }

    public synchronized static void increment() {
        COUNT++;
    }
//    public static void increment(){
// sychronized(SafeThread .class) {
//        COUNT++;
//    }
//}
// }

    public synchronized static void decrement(){
        COUNT--;
    }

    public synchronized void increment2(){
        COUNT++;
    }
}
