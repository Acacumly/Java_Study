package lesson2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadAdvantage {

    /**
     * 集合:
     * Collection(List,
     *           ------ArrayList
     *           ------LinkedList
     *           ------Set:   HashSet, TreeSet
     *            ...)
     * Map:      ------HashMap, TreeMap
     @param args
     */
     public static List<String> randomList(){
         char[] chars = {'a','b', 'c', 'd'};
         List<String> list = new LinkedList<>();
         for(int i = 0; i < 10_0000; i++){
             int random = new Random().nextInt(chars.length);
             char c = chars[random];
             list.add(String.valueOf(c));
         }
         return list;
     }

     public static void main(String[] args) throws InterruptedException {
         List<String> list = randomList();
         //创建10个线程, 每个线程获取List中的1000个元素
         //时间java.util.Date;
         //jdk.1.8 -> LocalDateTime
         long start = System.currentTimeMillis();
         //long start = new Date().getTime();
         Thread[] threads = new Thread[10];
         for(int i = 0; i < 10; i++) {
             final int k = i;
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     for (int j = 0; j < 10000; j++) {
                         list.get(k * 10000 + j);
                     }
                 }
             //}).start();
             },"我的线程" + k);
             threads[i].start();
         }
         //第一种做法:线程让步,yield
//         while(Thread.activeCount() > 2){
//             Thread.yield();
//         }
         //第二种做法:调用线程加入等待:join
         for(Thread thread : threads){
             thread.join();
         }
         //下面的这种方法,不能正确计算出耗时
         long end = System.currentTimeMillis();
         System.out.println("耗时: " + (end - start) + "毫秒");
     }
}
//哈希表 =  数组 + 链表
//HashMap = 数组 + 链表 + 红黑树
/**
 * Thread类的静态方法只作用于当前代码范围的线程:
 * Thread...
 * Thread类的实例方法
 * Thread.join()表示阻塞当前线程,而等待引用线程执行完毕
 */



