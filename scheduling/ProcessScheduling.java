package com.system.scheduling;
import com.system.control.Util;
import com.system.computer.cpu;
import com.system.computer.pcb;
import java.util.LinkedList;

/**
 * @author 李正阳  17060208112
 */
public class ProcessScheduling {


    static pcb prv = null;
    static LinkedList<pcb> res = new LinkedList<pcb>();
    public static void start(){
        LinkedList<pcb> external = Util.initProcess();
        finish(external);
        Util.print(res);
    }



    /**
     *
     * @param p 作业未到达时候用
     */
    private static void finish( LinkedList<pcb> p){
        /**
         * 作业还没有完全到达、作业没有全部做完、
         */
        while (p.size() != 0 || cpu.external.size() != 0 ||  cpu.queue.size() != 0 ||prv != null) {
            for (int i = 0; i < p.size(); i++) {
                pcb temp = p.get(i);
                /**
                 *模拟作业到达，进入等待队列
                 */
                if (temp.getArrive_time() == cpu.time) {
                    cpu.external.add(temp);
                    p.remove(temp);
                }
            }
            if(prv != null){
                cpu.external.add(prv);
            }
            while (cpu.external.size() != 0){
                pcb temp = cpu.external.getFirst();
                /**
                 * 模拟作业进入内存（只有两个道）
                 */
                if (cpu.queue.size() < cpu.queue_length) {
                    /**
                     * 记录进入内存的时间
                     */
                    if (temp.getFinish_level() == 0) {
                        temp.setInto_time(cpu.time);
                    }
                    /**
                     * 进入内存的过程，并且删除外存中的进程
                     */
                    cpu.queue.add(temp);
                    cpu.external.remove(temp);
                }else {
                    break;
                }
            }
            /**
             * 分配时间片
             */
            pcb head = cpu.queue.getFirst();
            head.finish_level++;
            /**
             * 任务完成，从内存中删除任务记录，完成时间，并且计算周转
             * 时间和带权周转时间
             */
            cpu.time ++;
            boolean index = false;
            if (head.getTotal_time() == head.getFinish_level()) {
                index = true;
                head.setFinish_time(cpu.time);
                head.setCycling_time(head.getFinish_time() - head.arrive_time);
                head.setAuthorized_turnaround_time(head.getCycling_time() / head.getTotal_time());
                res.add(head);
            }
            /**
             * 时间片结束，将内存中的进程删除，若任务未完成将置换出去的进程置为null
             */
            if(index){
                cpu.queue.removeFirst();
                prv = null;
            }else {
                prv = cpu.queue.removeFirst();
            }

        }
        /**
         * 如果置换出去的进程还没有执行完毕，
         */
        if(prv != null){
            res.add(prv);
        }
    }
}
