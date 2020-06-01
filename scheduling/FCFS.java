package com.system.scheduling;

import com.system.control.Util;
import com.system.computer.cpu;
import com.system.computer.pcb;

import java.util.LinkedList;

public class FCFS {
    static LinkedList<pcb> res = new LinkedList<pcb>();
    public static void start(){
        LinkedList<pcb> external = Util.initProcess();
        finish(external);
        Util.print(res);
    }
    private static void finish( LinkedList<pcb> p){
        /**
         * 当作业还没有完全到达、作业没有全部做完、CPU的内存等待队列中
         * 还有进程的时候，一直循环=，知道所有任务做完。
         */
        while (p.size() != 0 || cpu.external.size() != 0 ||  cpu.queue.size() != 0) {
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
             * 获取CPU中的时间，让时间加一
             * 同时任务完成时间也加一
             */
            pcb head = cpu.queue.getFirst();
            head.finish_level ++;
            cpu.time ++;
            /**
             * 若此时任务完成度和任务完成需要时间相等
             * 即任务执行完毕、计算周转时间和带权周转时间
             * 然后将内存队列中的此进程删除，并且添加到进程完成队列中
             */
            if (head.getTotal_time() == head.getFinish_level()) {
                head.setFinish_time(cpu.time);
                head.setCycling_time(head.getFinish_time() - head.arrive_time);
                head.setAuthorized_turnaround_time(head.getCycling_time() / head.getTotal_time());
                res.add(cpu.queue.removeFirst());
            }
        }
    }

}
