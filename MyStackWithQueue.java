import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithQueue {
    private Queue<Integer> queue = new LinkedList<>();
    /** Initialize your data structure here. */

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
//        int sz = queue.size();
//        while(sz > 1) {
//            queue.add(queue.remove());
//            sz--;
//        }
    }

    public int pop() {
        //先把前size-1个数,处理
        int size = queue.size();
        for(int i = 0;  i < size - 1; i++) {
            int v = queue.poll();
            queue.add(v);
        }
        return queue.poll();
    }
    public int top() {
        int size = queue.size();
        for(int i = 0; i < size - 1; i++) {
            int v = queue.poll();
            queue.add(v);
        }
        int v = queue.poll();
        queue.add(v);
        return v;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
