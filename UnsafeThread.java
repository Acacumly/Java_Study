package lesson3;

public class UnsafeThread {
    public static int COUNT;

    public static void main(String[] args) {
        //开启20个线程,每个线程对COUNT进行++操作10000次
        //预期结果:200000
        for(int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        COUNT++;
                    }
                }
            }).start();
        }
        System.out.println(COUNT);
    }
//
//    public static voi Od main(String[] args) {
//        String s1 = "abc";
//        String s2 = new String("a");//创建了两个对象  堆里创建new  常量池创建a
//        String s3 = new String("abc");//创建了一个对象
//    }
}