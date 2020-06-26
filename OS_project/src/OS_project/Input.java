package OS_project;

        import com.sun.org.apache.bcel.internal.generic.SWITCH;
        import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
        import java.util.*;
        import java.util.*;

class pcb{
    String tag;//标记
    int intime;//进入时间
    int serv;//服务时间
    int prio;//优先级
    double wrun; //带权周转
    int end; //完成时间
    int run; //周转时间
    int sheng; //剩余时间
    boolean ok=false;  //是否执行完成
    public pcb(){};
    public pcb(String tag,int intime,int serv,int prio,int end,double wrun,int run){
        this.tag=tag;
        this.intime=intime;
        this.serv =serv;
        this.prio=prio;
        this.end=end;
        this.wrun=wrun;
        this.run=run;
    }

    public boolean isOk() {
        return ok;
    }
    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getSheng() {
        return sheng;
    }

    public void setSheng(int sheng) {
        this.sheng = sheng;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setIntime(int intime) {
        this.intime = intime;
    }

    public void setServ(int serv) {
        this.serv = serv;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }
    public void setWrun(double wrun){
        this.wrun=wrun;
    }
    public void setEnd(int end){
        this.end=end;
    }
    public void setRun(int run){
        this.run=run;
    }
    public String getTag() {
        return tag;
    }

    public int getIntime() {
        return intime;
    }

    public int getServ() {
        return serv;
    }

    public int getPrio() {
        return prio;
    }
    public int getEnd(){
        return end;
    }

    public int getRun() {
        return run;
    }
    public double getWrun() {
        return wrun;
    }

    public static class sortbyIntime implements Comparator<pcb>{  //进入时间排序

        @Override
        public int compare(pcb o1, pcb o2) {
            return o1.getIntime()-o2.getIntime();
        }
    }
    public static class sortbyPrio implements Comparator<pcb>{ //优先级排序

        @Override
        public int compare(pcb o1, pcb o2) {
            if (o1.getIntime()-o2.getIntime()!=0) return o1.getIntime()-o2.getIntime(); //进入时间不同，按进入时间升序
            else return o2.getPrio()-o1.getPrio(); //进入时间相同时按优先级降序排列
        }
    }
    public static class shortbyServ implements Comparator<pcb>{ //短作业排序

        @Override
        public int compare(pcb o1, pcb o2) {
            if (o1.getIntime()-o2.getIntime()!=0) return o1.getIntime()-o2.getIntime(); //按进入时间升序
            else return o1.getServ()-o2.getServ(); //按短作业升序
        }
    }
    public static class shortbyRr implements Comparator<pcb>{ //时间片轮转

        @Override
        public int compare(pcb o1, pcb o2) {
            return o1.getEnd()-o2.getEnd(); //按完成时间升序
        }
    }
}

public class Input {
    public static void calculate(pcb[] pcbs){  //计算
        int end1=pcbs[0].getIntime()+pcbs[0].getServ();
        pcbs[0].setEnd(end1);
        for (int i=1;i<pcbs.length;i++){ //完成时间
            pcbs[i].setEnd(pcbs[i-1].getEnd()+pcbs[i].getServ());
        }
        for (int i=0;i<pcbs.length;i++){   //周转时间
            pcbs[i].setRun(pcbs[i].getEnd()-pcbs[i].getIntime()); //周转时间=完成时间-进入时间
        }
        for (int i=0;i<pcbs.length;i++){ //带权周转时间
            pcbs[i].setWrun((double)(pcbs[i].getRun()/pcbs[i].getServ())); //带权周转时间=周转时间/服务时间
        }

        System.out.println("标识符  进入时间  服务时间  优先级  完成时间  周转时间");
        for (int i=0;i<pcbs.length;i++){
            System.out.print(pcbs[i].getTag());
            System.out.print("        ");
            System.out.print(pcbs[i].getIntime());
            System.out.print("        ");
            System.out.print(pcbs[i].getServ());
            System.out.print("        ");
            System.out.print(pcbs[i].getPrio());
            System.out.print("        ");
            System.out.print(pcbs[i].getEnd());
            System.out.print("        ");
            System.out.println(pcbs[i].getRun());
            //System.out.print("        ");
            //System.out.println(pcbs[i].getWrun());
        }
    }
    public static void FCFS(pcb[] pcbs, int q){ //先来先服务
        //Arrays.sort(pcbs,0,q);
        Arrays.sort(pcbs,new pcb.sortbyIntime());
        calculate(pcbs);
    }
    public static void PSA(pcb[] pcbs,int q){ //优先级优先
        Arrays.sort(pcbs,new pcb.sortbyPrio());
        calculate(pcbs);

    }
    public static void RR(pcb[] pcbs,int q){ //时间片轮转
        Arrays.sort(pcbs,new pcb.sortbyIntime());  //进入时间排序
        // calculate(pcbs);
        //List<pcb> al=new ArrayList<pcb>();
        Queue<pcb> que=new LinkedList<pcb>();
        int count=0;
        int sumtime=pcbs[0].getIntime();
        for (int i=0;i<pcbs.length;i++){ //初始化剩余时间
            pcbs[i].setSheng(pcbs[i].getServ());
        }
        que.offer(pcbs[0]);
        while(count<pcbs.length) {
            pcb a = que.poll();
            if (a.getSheng()>q){
                sumtime=sumtime+q;
                a.setSheng(a.getSheng()-q);
            }else if (a.getSheng()<=q){
                sumtime=sumtime+a.getSheng();
                a.setOk(true);
                a.setEnd(sumtime);
                count++;
            }
            for (int i=0;i<pcbs.length;i++){
                if (pcbs[i].getIntime()<=sumtime&&pcbs[i]!=a&&!que.contains(pcbs[i])&&!pcbs[i].isOk()){
                    que.offer(pcbs[i]);
                }
            }
            if (!a.isOk()){
                que.offer(a);
            }
        }
        for (int i=0;i<pcbs.length;i++){ //周转时间
            pcbs[i].setRun(pcbs[i].getEnd()-pcbs[i].getIntime());
        }
        for (int i=0;i<pcbs.length;i++){ //带权周转时间
            pcbs[i].setWrun((double) (pcbs[i].getRun()/pcbs[i].getServ()));
        }
        System.out.println("标识符  进入时间  服务时间  优先级  完成时间  周转时间");
        for (int i=0;i<pcbs.length;i++){
            System.out.print(pcbs[i].getTag());
            System.out.print("        ");
            System.out.print(pcbs[i].getIntime());
            System.out.print("        ");
            System.out.print(pcbs[i].getServ());
            System.out.print("        ");
            System.out.print(pcbs[i].getPrio());
            System.out.print("        ");
            System.out.print(pcbs[i].getEnd());
            System.out.print("        ");
            System.out.println(pcbs[i].getRun());
            //System.out.print("        ");
            //System.out.println(pcbs[i].getWrun());
        }
    }

    public static void SJF(pcb[] pcbs,int q){  //短作业优先
        Arrays.sort(pcbs,new pcb.shortbyServ());
        calculate(pcbs);

    }

    public static void main(String[] args){
        int num=0;
        int timel=0;
        System.out.println("请输入进程个数和时间片长短：");
        Scanner s=new Scanner(System.in);
        num=s.nextInt();
        timel=s.nextInt();
        pcb[] pcbs_all=new pcb[num];
        System.out.println("依次输入进程标识符，进入时间，服务时间，优先级");
        for (int i=0;i<num;i++){
            pcb p=new pcb();
            p.setTag(s.next());
            p.setIntime(s.nextInt());
            p.setServ(s.nextInt());
            p.setPrio(s.nextInt());
            pcbs_all[i]=p;
        }

        System.out.println("标识符  进入时间  服务时间  优先级");
        for(int j=0;j<pcbs_all.length;j++){
            System.out.print(pcbs_all[j].getTag());
            System.out.print("        ");
            System.out.print(pcbs_all[j].getIntime());
            System.out.print("        ");
            System.out.print(pcbs_all[j].getServ());
            System.out.print("        ");
            System.out.println(pcbs_all[j].getPrio());
        }
        System.out.println("输出进程个数和时间片长短");
        System.out.print(num);
        System.out.print("   ");
        System.out.println(timel);
        System.out.println("选择算法1.先来先服务 2.优先级调度 3.短作业优先  4.时间片轮转");
        int ss=s.nextInt();
        switch(ss){
            case 1:FCFS(pcbs_all,num);break;
            case 2:PSA(pcbs_all,num);break;
            case 3:SJF(pcbs_all,num);break;
            case 4:RR(pcbs_all,timel);break;
        }
        s.close();
    }
}
