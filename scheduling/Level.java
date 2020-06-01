package com.system.scheduling;

import com.system.control.Util;
import com.system.computer.cpu;
import com.system.computer.pcb;

import java.util.LinkedList;

public class Level {
    static LinkedList<pcb> res = new LinkedList<>();
    public static void start(){
        LinkedList<pcb> external = Util.initProcess();
        finish(external);
        Util.print(res);
    }

    private static void finish(LinkedList<pcb> p){
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
             * 给内存中所有未运行的作业排序（按照优先级）
             * 优先级高的先进入内存
             */
            int n ;
            pcb head = cpu.queue.getFirst();
            if(head.getFinish_level() == 0){
                n = 0;
            }else {
                n = 1;
            }
            for(int i = n;i < cpu.queue.size(); i++){
                for(int j = n + 1;j < cpu.queue.size() ; j++){
                    pcb temp ;
                    pcb pre = cpu.queue.get(j);
                    /**
                     * 默认为数字越低优先级越高
                     */
                    if(cpu.queue.get(i).getPriority() > pre.getPriority()){
                        temp = pre;
                        pre = cpu.queue.get(i);
                        cpu.queue.set(i,temp);
                    }
                }
            }
            head.finish_level ++;
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
