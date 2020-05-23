package lesson2;

public class MyThread {
    public static void main(String[] args) {
       //创建并启动线程,会在操作系统中真实的创建并申请系统调度该线程,在申请后由cpu时间片调度执行,(就绪到运行)
             new Thread(new Runnable() { //new Thread 创建了一个线程
                 @Override
                 public void run() {
                     System.out.println("明天双11");
                 }
             });
             //}).start();
            // thread.start();
             //不调用join时,创建线程会耗时较长,下边的main方法
            //的代码会先执行
            //如果调用join方法,表示thread(线程的引用)会加入当前
            //线程(JavaMain主线程), 等待thread执行完毕再执行
            // thread.join();
             //下面的代码通常是先执行,因为以上创建线程部分很耗时
        System.out.println("今天是周天");
//             Runnable runnable = new Runnable() {
//                 @Override
//                 public void run() {
//
//                 }
//             };
//             Thread thread = new Thread(runnable);
    }
}
