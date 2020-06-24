import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static	Scanner scanner=new Scanner(System.in);
    static int n;//进程数量
    static int m;//资源种类数
    static int[] available;
    static int max[][];//最大需求矩阵
    static int allocation[][];//当前分配到每个进程的
    static int need[][];//需求矩阵
    static boolean[] isrelesed;//资源是否已经释放
    /*
     * 输出状态
     */
    static void getstatus() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
            {
                need[i][j]=max[i][j]-allocation[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("进程"+i+"的状态为:max:");
            for(int j=0;j<m;j++) {
                System.out.print(" "+max[i][j]+" ");
            }
            System.out.println("allocatem: ");
            for(int j=0;j<m;j++) {
                System.out.print(" "+allocation[i][j]+" ");
            }
            System.out.println("need: ");
            for(int j=0;j<m;j++) {
                System.out.print(" "+need[i][j]+" ");
            }
            System.out.println("avaliable: ");
            for(int j=0;j<m;j++)
            {
                System.out.print(" "+available[j]+" ");
            }
            System.out.println();
        }
    }
    /*
     * 初始化与资源种类相关变量
     */
    static void initm(int m) {
        System.out.println("请输入"+m+"种资源的最大量");
        available=new int[m];
        isrelesed=new boolean[m];
        for(int i=0;i<m;i++)
        {
            available[i]=scanner.nextInt();
        }
    }
    /*
     * 初始化与线程相关的变量
     */
    static void initn(int n) {
        max=new int[n][m];
        allocation=new int[n][m];
        need=new int[n][m];
        for(int i=0;i<n;i++)
        {
            System.out.println("进程"+i+"的最大需求为:(输入m个数)");
            boolean jud=false;
            for(int j=0;j<m;j++) {
                max[i][j]=scanner.nextInt();
                if (max[i][j]>available[j]) {
                    jud=true;
                }
            }
            if (jud) {
                System.out.println("最大需求输入有误,请重新赋值(m个数)");
                i--;
            }
        }
        System.out.println("n个线程m种资源最大需求赋值完成\n请输入当前进程已分配资源情况");
        //初始化allocate矩阵
        for(int i=0;i<n;i++) {
            System.out.println("进程"+i+"已分配资源为:(输入m个数)");
            boolean jud=false;
            for (int j = 0; j < m; j++) {
                allocation[i][j]=scanner.nextInt();
                if (allocation[i][j]>max[i][j]) {
                    jud=true;
                }
            }
            if (jud) {
                System.out.println("输出有误,请重新输入:");
                i--;
            }
        }
        System.out.println("allocate(当前已分配矩阵已经分配完毕)");
    }
    private static boolean issafety(int work[],boolean finish[],int need2[][],int allocate2[][])//模拟的需求和分配
    {
        //int work[]=available.clone();//不能直接等于复制。可以了解下对象克隆或者深浅复制。
        Queue<Integer>q1=new ArrayDeque<Integer>();//如果能完成的队列
        int time=0;
        while(true)
        {
            boolean loop=true;
            for(int i=0;i<n;i++)//n个进程模拟
            {
                time++;
                if(!finish[i]) {
                    boolean b=false;//完成不了的
                    for(int j=0;j<m;j++)
                    {
                        if(work[j]<need2[i][j])
                        {
                            b=true;//完成不了的
                        }
                        if(b) {break;}
                    }
                    if(!b) {//可以完成的,释放资源
                        time=0;//重新计数
                        q1.add(i);
                        finish[i]=true;//已经完成
                        for(int j=0;j<m;j++)
                        {
                            work[j]+=allocate2[i][j];//
                            allocate2[i][j]+=need2[i][j];
                            need2[i][j]=0;
                        }
                        //打印
                        System.out.print("进程"+i+" max:");
                        for(int j=0;j<m;j++)
                        {
                            System.out.print(max[i][j]+" ");
                        }
                        System.out.print("allocate2: ");
                        for(int j=0;j<m;j++)
                        {
                            System.out.print(allocate2[i][j]+" ");
                        }
                        System.out.print("need2: ");
                        for(int j=0;j<m;j++)
                        {
                            System.out.print(need2[i][j]+" ");
                        }
                        System.out.print("work: ");
                        for(int j=0;j<m;j++)
                        {
                            System.out.print(work[j]+" ");
                        }
                        System.out.println();
                    }
                }
            }
            boolean isfinish=false;
            for(int i=0;i<n;i++)
            {
                if(!finish[i]) {isfinish=true;break;}
            }
            if(!isfinish) {return true;}
            if(time>n) {return false;}
        }
        //return false;
    }
    /*
     * 假设分配
     */
    private static boolean ifallocate(int index,int[] request) {
        //首先要将真的数组克隆,模拟已经给资源,然后判断这个资源是否安全
        int work[] = available.clone();
        boolean finish[]= isrelesed.clone();
        int need2[][]=new int[n][m];
        int allocate2[][]=new int[n][m];
        for(int i=0;i<n;i++) {
            need2[i]=need[i].clone();
            allocate2[i]=allocation[i].clone();
        }
        for (int i = 0; i < m; i++) {
            if(need[index][i]<request[i])
                request[i]=need[index][i];
            work[i]-=request[i];
            allocate2[index][i]+=request[i];
        }
        //重置 need2
        for(int i=0;i<m;i++)
        {
            need2[index][i]-=request[i];
        }
        boolean isallocate=issafety(work, finish, need2, allocate2);
        if(!isallocate) {System.out.println("分配造成进程不安全,取消分配"); return false;}
        else {
            System.out.println("分配成功");
            //分配成功就要分配资源
            for(int i=0;i<m;i++)
            {
                available[i]-=request[i];
                allocation[index][i]+=request[i];
                need[index][i]-=request[i];
                //System.out.println(request[i]);
            }
            if(!isrelesed[index])//判断改资源是否释放
            {
                boolean jud=false;
                for(int j=0;j<m;j++)
                {
                    if(need[index][j]!=0)jud=true;
                }
                if(!jud)//资源需要释放
                {
                    isrelesed[index]=true;
                    for(int j=0;j<m;j++)
                    {
                        available[j]+=allocation[index][j];
                    }
                }
            }
        }
        boolean isfinished=true;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) {
                if(need[i][j]!=0) {isfinished=false;return false;}}
        }
        return isfinished;
    }
    /*
     * 申请资源
     */
    static void applyresourse() {
        getstatus();//输出状态
        int request[] =new int[m];//需求量
        System.out.println("输入你想申请资源的编号");
        int index=scanner.nextInt();
        while(0>index||index>=n) {
            System.out.println("输入的编号不在编号范围之内,请重新输入");
            index=scanner.nextInt();
            while(isrelesed[index]) {
                System.out.println("改编已经完成资源的释放,无法再请求资源,请重新输入");
                index=scanner.nextInt();
                while(0>index||index>n) {
                    System.out.println("输入的编号不在编号范围之内,请重新输入");
                    index=scanner.nextInt();
                    System.out.println("请输入"+m+"个资源申请的个数(不申请的资源用0替代)");
                    int team=0;
                    while(team==0) {
                        for(int i=0;i<m;i++) {
                            request[i]=scanner.nextInt();
                            if (request[i]>available[i]) {
                                team=1;
                            }
                            if (request[i]>max[index][i]) {
                                team=2;
                            }
                        }
                        if (team==1) {
                            System.out.println("您的请求量超出了系统提供量,请重新输入");
                            team=0;
                        }else if(team==2) {
                            System.out.println("您的请求量超出了最大请求量max,请重新输入");
                            team=0;
                        }else {
                            team=3;
                        }
                        boolean isfinish=ifallocate(index,request);
                        if (isfinish) {
                            System.out.println("所有进程完成资源分配,分配结束");
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入资源种类数m:");
        m=scanner.nextInt();
        initm(m);
        System.out.println("输入进程数量n:");
        n=scanner.nextInt();
        initn(n);
        while(true) {
            applyresourse();//申请资源
        }
    }

}
