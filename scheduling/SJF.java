package com.system.scheduling;

import com.system.control.Util;
import com.system.computer.cpu;
import com.system.computer.pcb;

import java.util.LinkedList;

public class SJF {
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
        while (p.size() != 0 || cpu.external.size() != 0 ||  cpu.queue.size() != 0 ) {
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
                pcb temp = cpu.findMinTotalTime();

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
                    /**
                     * 拿到内存中最大时间进程，然后从内存队列找到需要时间最短的
                     * 进入内存。
                     */
                    pcb temp1 = cpu.findQueueMaxTotalTime();
                    if(temp.getTotal_time() < temp1.getTotal_time()){
                        cpu.queue.remove(temp1);
                        cpu.external.add(temp1);
                        cpu.queue.add(temp);
                        cpu.external.remove(temp);
                    }else{
                        break;
                    }
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
             * 然后将内存队列中的此进程删除，并且添加到进程完成队列中
             */
            cpu.time ++;
            if (head.getTotal_time() == head.getFinish_level()) {
                head.setFinish_time(cpu.time);
                head.setCycling_time(head.getFinish_time() - head.arrive_time);
                head.setAuthorized_turnaround_time(head.getCycling_time() / head.getTotal_time());
                res.add(cpu.queue.removeFirst());
            }
        }
    }
}


