package lesson4;

import java.util.ArrayList;
import java.util.List;

public class SafeThread {

    public static int COUNT;

    public static void main(String[] args) throws InterruptedException {
        // 开启20个线程，每个线程对COUNT进行++操作10000次
        // 预期结果：200000
        Object object = new Object();
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    Object object = new Object();
                    for(int j=0; j<10000; j++){
//                        COUNT++;
                        // 第一种：静态类对象锁定
                        increment();
                        decrement();
                        // 第二种：对实例对象锁定
//                        synchronized (object){
//                            COUNT++;
//                        }
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(COUNT);
    }

    public synchronized static void increment(){
        COUNT++;
    }

//    public static void increment(){
//        synchronized (SafeThread.class){
//            COUNT++;
//        }
//    }

    public synchronized static void decrement(){
        COUNT--;
    }

    public synchronized void increment2(){

    }

//    public void increment2(){
//        synchronized (this){
//
//        }
//    }
}
