package lesson2;

public class StopThread {

    /**
     * 是否被中断：默认没有被中断false
     */
    private static volatile boolean myInterrupted;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!myInterrupted){
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(5000);
        myInterrupted = true;
    }
}
