package lesson7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

//    private static final ExecutorService EXE
//            = Executors.newSingleThreadExecutor();
    private static final ExecutorService EXE
        = Executors.newFixedThreadPool(5);
//    private static final ExecutorService EXE
//        = Executors.newCachedThreadPool();
//    private static final ExecutorService EXE = Executors.newScheduledThreadPool();

    public static void main(String[] args) {
        // 初始化为5个大小
        for(int i=0; i<100; i++){
            final int j = i;
            EXE.submit(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
//        EXE.shutdown();
    }
}
