package lesson3;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(Thread.currentThread().isInterrupted()){ //判断结果为中断
                    System.out.println("运行中");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread.sleep(3000);
        thread.interrupt();
    }
}
