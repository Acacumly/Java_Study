package com.system.control;
import com.system.computer.cpu;
import com.system.computer.pcb;
import com.system.scheduling.FCFS;
import com.system.scheduling.Level;
import com.system.scheduling.ProcessScheduling;
import com.system.scheduling.SJF;

import java.util.LinkedList;
import java.util.Scanner;

public class Util {
    /**
     * 输出结果链表中的内容
     * @param res
     */
    public static void print(LinkedList<pcb> res){
        while(!res.isEmpty()){
            System.out.println(res.removeFirst().toString());
        }
    }
    /**
     * 进行算法选择
     */
    public static void start(){
        Scanner in  = new Scanner(System.in);
        System.out.println("请输入需要设置哪一种算法");
        System.out.println("A：先来先服务");
        System.out.println("B：短进程优先");
        System.out.println("C：高优先级优先");
        System.out.println("D：时间片轮转");
        switch(in.next()){
            case "A":
                FCFS.start();break;
            case "B":
                SJF.start();break;
            case "C":
                Level.start();break;
            case "D":
                ProcessScheduling.start();break;
            default:System.out.println("选择错误!");
        }
    }
    /**
     * 初始化需要运行的进程
     */
    public static LinkedList<pcb> initProcess(){
        Scanner in  = new Scanner(System.in);
        System.out.println("是否自定义cpu:(1为自定义的cpu，0为默认) ");
        if(in.nextInt() == 1 ){
            System.out.println("请输入cpu能同时运行几个进程,以及等待队列（进入内存能有多少个进程）");
            cpu.initcpu(in.nextInt(),in.nextInt());
        }
        System.out.println("|请输入一共几个进程：");
        int n = in.nextInt();
        LinkedList<pcb>external = new LinkedList<pcb>();
        for(int i = 0;i < n; i++){
            System.out.println("|输入进程的名字、到达时间、" +
                    "|任务完成需要的时间、" +
                    "|优先级");
            pcb temp = new pcb(in.next(),in.nextInt(),in.nextInt(),in.nextInt());
            external.add(temp);
        }
        return external;
    }
}
