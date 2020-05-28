package lesson7;

import java.util.TimerTask;
import java.util.concurrent.PriorityBlockingQueue;

public class TimerTest2 {
    public static void main(String[] args) {

    }
}

class MyTimer2{
    private PriorityBlockingQueue<Timer2Task>

    public
    public void schedule(Runnable task, long delay, long period){
        queue.offer(new TimerTask(task, delay, period));
    }
}

class Timer2Task implements Comparable<Time2Task>{
    @Override
    public int compareTo(Time2Task o) {
        return 0;
    }
}

class Timer2Task implements Comparable<Timer2Task>{

    private Runnable task;
    private long next;
    private long period;

    public Timer2Task(Runnable task, long delay, period){

    }
    //wait to sleep
    //设计一个schedule 定时方法
    //尽可能把参数简单化
    //

}