import java.util.Scanner;

public class Banker {
    Scanner in = new Scanner(System.in);
    int Pnum; // 进程个数
    int Stype; // 资源种类数
    int[] Ssum;// 各类资源总数

    int[][] Max;// 最大需求矩阵
    int[][] Allocation;// 已分配矩阵
    int[][] Need;// 需求矩阵
    int[] Available; // 可用资源数
    int[] Work;// Available的试分配向量
    boolean[] Finish = new boolean[50];// 试分配结果标识向量

    public Banker() {
        start();

    }

    public void start() {
        System.out
                .println("***********************************************************");
        System.out
                .println("                                         欢迎使用银行家算法");
        System.out
                .println("                                                                    ");
        System.out
                .println("***********************************************************");
        System.out.println("请选择操作：\n\t1.开始使用\n\t2.退出");
        int a;
        a = in.nextInt();
        if (a == 1) {
            input();
        } else {
            quit();

        }
    }

    public void input() {
        System.out.println("请输入T0时刻进程个数Pnum：");
        this.Pnum = in.nextInt();
        System.out.println("请输入资源种类数Stype:");
        this.Stype = in.nextInt();
        this.Ssum = getSsum();
        this.Max = getMax();
        this.Allocation = getAllocation();
        this.Need = getNeed();
        this.Available = getAvailable(Pnum, Stype);
        System.out.println("该时刻的资源分配表：");
        output();
        this.Check_Safe(Available);
        this.Ask_Distribution(false);
    }

    public int[] getSsum() {
        Ssum = new int[Stype];
        System.out.println("请输入各类资源总数Ssum:");
        for (int i = 0; i < Stype; i++) {
            Ssum[i] = in.nextInt();
        }
        return Ssum;
    }

    public int[][] getMax() {
        Max = new int[Pnum][Stype];
        System.out.println("请输入最大需求矩阵Max:");
        for (int i = 0; i < Pnum; i++) {
            for (int j = 0; j < Stype; j++) {
                Max[i][j] = in.nextInt();
            }
        }
        return Max;
    }

    public int[][] getAllocation() {
        Allocation = new int[Pnum][Stype];
        System.out.println("请输入已分配资源情况矩阵Allocation");
        for (int i = 0; i < Pnum; i++) {
            for (int j = 0; j < Stype; j++) {
                Allocation[i][j] = in.nextInt();
            }
        }
        return Allocation;
    }

    public int[][] getNeed() {
        Need = new int[Pnum][Stype];
        for (int i = 0; i < Pnum; i++) {
            for (int j = 0; j < Stype; j++) {
                Need[i][j] = Max[i][j] - Allocation[i][j];

            }
        }
        return Need;
    }

    public int[] getAvailable(int x, int y) {
        Available = new int[Stype];
        Available = Ssum;
        System.out.println("进程的可用资源Available为：");
        for (int j = 0; j < Stype; j++) {
            for (int i = 0; i < Pnum; i++) {
                Available[j] = Available[j] - Allocation[i][j];
            }
            System.out.print(Available[j] + " ");
        }
        System.out.println("");
        return Available;
    }

    public void setFinish(int x) {
        for (int i = 0; i < Pnum; i++) {
            Finish[i] = false;
        }
    }

    public boolean Check_Safe(int avail[]) {
        boolean boo = false;
        int k[] = new int[Pnum];
        int a = 0;
        Work = new int[Stype];
        for (int i = 0; i < avail.length; i++) {
            Work[i] = avail[i];
        }

        setFinish(Pnum);
        for (int s = 0; s < Pnum; s++) {

            for (int i = 0; i < Pnum; i++) {
                if (Finish[i] == false) {

                    for (int j = 0; j < Stype; j++) {
                        if (Need[i][j] <= Work[j]) {
                            if (j + 1 == Stype) {
                                Finish[i] = true;
                                k[a] = i;
                                a++;
                                for (int m = 0; m < Stype; m++) {
                                    Work[m] = Work[m] + Allocation[i][m];
                                }

                            } else {
                                continue;
                            }

                        } else {
                            break;
                        }
                    }

                } else {
                    continue;
                }
            }
        }
        if (a == Pnum) {
            System.out.println("此刻系统处于安全状态，存在安全序列为：");

            for (int i = 0; i < Pnum; i++) {
                System.out.print("P" + k[i] + "\t");
            }
            System.out.println("");
            boo = true;

        } else {
            System.out.println("此时系统处于非安全状态");
            choice();
            boo = false;
        }
        return boo;

    }

    public void Ask_Distribution(boolean b) {
        int a = 0;
        int a0=0;
        int a1 = 0;
        boolean bo = false;
        for (int i = 0; i < Stype; i++) {
            Work[i] = Available[i];
        }

        System.out.println("请输入请求分配的进程编号：");
        int m = in.nextInt();
        System.out.println("请输入请求的各资源数");
        int dis[] = new int[Stype];
        for (int i = 0; i < Stype; i++) {
            dis[i] = in.nextInt();
        }
        for (int i = 0; i < Stype; i++) {
            if (dis[i] <= Need[m][i]) {
                a++;
                continue;

            } else {
                System.out.println("出错！！！请求资源数大于需求资源数!");
                choice();
                break;
            }
        }
        if (a == Stype) {
            for (int i = 0; i < Stype; i++) {
                if (dis[i] <= Work[i]) {
                    a0=a0+1;
                    if(a0==Stype){
                        for (int j = 0; j < dis.length; j++) {
                            Work[j] = Work[j] - dis[j];
                            Allocation[m][j] = Allocation[m][j] + dis[j];
                            Need[m][j] = Need[m][j] - dis[j];
                        }
                        bo = Check_Safe(Work);
                    }
                    continue;
                } else {
                    System.out.println("出错！！！请求资源数大于可用资源数!");
                    choice();
                    break;
                }
            }
        }


        if (bo) {
            for (int i = 0; i < Stype; i++) {
                Available[i] = Available[i]-dis[i];
                if (Allocation[m][i] == Max[m][i]) {
                    a1 = a1 + 1;
                }
                while (a1 == Stype) {
                    System.out.println("(进程P"+m+"对资源的最大需求已满足，对其占有资源进行回收)");
                    for (int j = 0; j <Stype; j++) {
                        Available[j] = Available[j] + Allocation[m][j];
                    }
                    break;

                }

            }
            System.out.println("因此可以满足" + m + "进程的请求，分配后的各种变量值更新为:");
            output();
            choice();

        }else{
            for (int i = 0; i < dis.length; i++) {
                Work[i] = Work[i] + dis[i];
                Allocation[m][i] = Allocation[m][i] - dis[i];
                Need[m][i] = Need[m][i] + dis[i];
            }
        }
    }

    public void output() {

        System.out.println(" 进程     max\t\tallocation\t  need\t\tavailable");
        System.out.print("P0  ");
        for (int i = 0; i < Stype; i++) {
            System.out.print(Max[0][i] + "   ");
        }
        System.out.print(" 	");
        for (int i = 0; i < Stype; i++) {
            System.out.print(Allocation[0][i] + "   ");
        }
        System.out.print(" 	");
        for (int i = 0; i < Stype; i++) {
            System.out.print(Need[0][i] + "   ");
        }
        System.out.print(" 	");
        for (int i = 0; i < Stype; i++) {
            System.out.print(Available[i] + "   ");
        }
        System.out.println();
        for (int i = 1; i < Pnum; i++) {
            System.out.print("P" + i + "  ");
            for (int j = 0; j < Stype; j++) {
                System.out.print(Max[i][j] + "   ");
            }
            System.out.print(" 	");
            for (int j = 0; j < Stype; j++) {
                System.out.print(Allocation[i][j] + "   ");
            }
            System.out.print(" 	");
            for (int j = 0; j < Stype; j++) {
                System.out.print(Need[i][j] + "   ");
            }

            System.out.println();
        }

    }

    public void choice() {
        System.out.println("*****************************************");
        System.out.println("“Y”选择再次输入\n“N”返回银行家算法初始位置");
        System.out.println("****************************************");
        String str = in.next();
        if (str.equals("y")) {
            Ask_Distribution(false);
        } else {
            new Banker();
        }
    }

    public void quit() {
        System.out.println("您确定要退出吗?请选择“Y”/“N”");
        String a = in.next();
        if (a.equals("Y")) {
            System.out.println("**************感谢您的使用！**************");

        } else {
            start();
        }
    }

    public static void main(String[] args) {
        Banker yh = new Banker();
    }
}
