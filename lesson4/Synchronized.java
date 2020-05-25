package lesson4;

public class Synchronized {
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }

    public static void main(String[] args) {
        MyObject object = new MyObject();
        MyObject object2 = new MyObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                object.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                object2.method2();
            }
        }).start();
    }
}

class MyObject{
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
}