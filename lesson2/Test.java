package lesson2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
    public class Test {
        /**
         * 集合：
         * Collection  /  ----List
         *                          ArrayList
         *                          LinkedList
         *                    Set:  HashSet,TreeSet
         * Map        / ------Map:  HashMap,TreeMap
         * 链表查询时效率较低
         **/
        public static List<String> randomList(){
            char[] chars ={'a','b','c','z','A','Z'};
            List<String> list = new LinkedList<>();
            for (int i = 0;i < 10_0000;i++){
                int random = new Random().nextInt(chars.length);
                char c = chars[random];
                list.add(String.valueOf(c));
            }
            return list;
        }
        public static void main(String[] args) {
            long start = System.currentTimeMillis();
            List<String> list = randomList();
            //创建10个线程，每个线程获取List中的10000个元素
            for (int i = 0;i < 10;i++){
                final int k = i;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 0; j < 10000;j++){
                            list.get(k*10000+j);
                        }
                    }
                }).start();
            }
            while (Thread.activeCount() > 2){
                Thread.yield();
            }
            long end = System .currentTimeMillis();
            System.out.println("耗时:"+(end - start)+"毫秒");
        }
    }
