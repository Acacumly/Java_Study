package lesson2;

public class StopThread {
    /**
     * volatile  使用于多线程,(可有可无)
     * @param args
     */
    private static volatile boolean myInterrupted;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(myInterrupted){
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //Thread.sleep(5000);
        myInterrupted = true;
    }
}
