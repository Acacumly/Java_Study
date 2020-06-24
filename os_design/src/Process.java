import java.sql.ResultSet;
import java.time.Year;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Process {
    Scanner scanner = new Scanner(System.in);
    int[] Resource = new int[50];//表示当前资源数容量
    int[] Process = new int[50];//表示当前进程容量
    int[][] maxneed = new int[50][50];//表示某进程对某类资源地最大需求
    int[][] allocation = new int[50][50];//表示某个进程已分配到某类资源地个数
    int[][] need = new int[50][50];//表示当前某个进程尚需要某类资源地个数
    int[] avaliable = new int[50];//表示当前某类资源地可用数
    int[] work = new int[50];//表示当前work地值
    boolean[] finish = new boolean[50];//表示该进程是否已分配
    int[] request = new int[50];//进程请求资源
    int rtype;//标识资源种类数目
    int rnum;//标识各类别的资源数
    int pnum;//标识进程的数目
    boolean flag = false;//代表当前进程地需求是否小于可利用资源
    boolean flag1 = false;//代表系统是否处于安全状态

    public void resource() {
        System.out.println("请输入资源的种类数目: ");
        rtype = scanner.nextInt();
        for (int i = 0; i < rtype; i++) {
            System.out.print("请输入第" + (i + 1) + "类资源的数目:" + "\t");
            rnum = scanner.nextInt();
            Resource[i] = rnum;
        }
        System.out.println("当前输入的资源数分别为: ");
        for (int i = 0; i < rtype; i++) {
            System.out.print(Resource[i] + "\t");
        }
        System.out.println();
        System.out.println("请输入进程的数目: ");
        pnum = scanner.nextInt();
    }

    public void iniship() {//对资源的最大需求
        for (int i = 0; i < pnum; i++) {
            System.out.println("请输入P" + i + "进程对资源的最大需求:" + "\t");
            for (int j = 0; j < rtype; j++) {
                maxneed[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < pnum; i++) {//分配情况
            System.out.println("请输入P" + i + "进程的分配情况: ");
            for (int j = 0; j < rtype; j++) {
                allocation[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < pnum; i++) {//需求
            for (int j = 0; j < rtype; j++) {
                need[i][j] = maxneed[i][j] - allocation[i][j];
            }
        }
        for (int i = 0; i < rtype; i++) {
            int total = 0;
            for (int j = 0; j < pnum; j++) {
                total += allocation[j][i];
            }
            avaliable[i] = Resource[i] - total;
        }
        display();
    }

    public void display() {
        System.out.println("T0时刻的资源分配情况: ");
        System.out.println("\tMax\t\tAllocation\t\tNeed\t\tAvaliable\t\tfinish");
        System.out.println("进程\t\t\t\t");
        for (int i = 0; i < pnum; i++) {//显示T0时刻分配情况
            System.out.print("P" + i + "\t");
            for (int j = 0; j < rtype; j++) {
                System.out.print(" " + maxneed[i][j]);
            }
            System.out.print("\t");
            for (int j = 0; j < rtype; j++) {
                System.out.print(" " + allocation[i][j]);
            }
            System.out.print("\t");
            for (int j = 0; j < rtype; j++) {
                System.out.print(" " + need[i][j]);
            }
            System.out.print("\t");
            for (int j = 0; j < rtype; j++) {
                System.out.print(" " + avaliable[j]);
            }
            System.out.print("\t");
                System.out.println(finish[i] = false);
            System.out.println();
        }
    }

    public boolean isSecurity(int num) {
        for (int i = 0; i < rtype; i++) {//初始化work
            work[i] = avaliable[i];
        }
        for (int i = 0; i < pnum; i++) {//初始化finish
            finish[i] = false;
        }
        int[] sequence = new int[pnum];//记录安全序列
        int count = 0;//作数组下标
        for (int k = 0; k < pnum; k++) {
            Loop:for (int i = 0; i < pnum; i++) {
                    for (int j = 0; j < rtype; j++) {
                        if (need[i][j] <= work[j] && finish[i] == false)
                            flag = true;
                        else {
                            flag = false;
                            continue Loop;
                        }
                    }
                    if (flag) {
                        for (int j = 0; j < rtype; j++)
                            work[j] += allocation[i][j];
                        finish[i] = true;
                        sequence[count] = i;
                        count++;
                    }
            }
        }
        int count1 = 0;//记录安全序列的个数
        boolean flag22 = false;//代表分配是否是等于最大需求
        for (int i = 0; i < sequence.length; i++) {
            if (finish[i] == true) {
                count1++;
            }
        }
        if (count1 == pnum) {
            System.out.println("T0时刻系统中存在一个安全序列:");
                for (int p = 0; p < pnum; p++)
                     System.out.print("P" + sequence + ",\t");
                    System.out.println();
            for (int i = 0; i < rtype; i++) {
                if (allocation[num][i] == maxneed[num][i])
                    flag22 = true;
                else {
                    flag22 = false;
                    break;
                }
            }
            if (flag22) {
                for (int i = 0; i < rtype; i++)
                    avaliable[i] = allocation[num][i] + avaliable[i];
            }
            flag1 = true;
            return true;
        } else {
            System.out.println("系统处于不安全状态!");
            flag1 = false;
            return false;
        }
    }

    public void isContinue() {
        boolean flag2 = false;//代表请求是否满足要求
        System.out.println("请输入一个进程序号:");
        int r = scanner.nextInt();
        System.out.println("请输入P" + r + "对资源的请求向量:");
        for (int i = 0; i < rtype; i++)
            request[i] = scanner.nextInt();
            for (int j = 0; j < rtype; j++) {
                if (request[j] <= need[r][j] && request[j] <= avaliable[j])
                    flag2 = true;
                else {
                    flag2 = false;
                    break;
                }
            }
            if (!flag2) {
                System.out.println("让P" + r + "等待!");
                boolean flag11 = false;//代表此时是否还有资源
                for (int k = 0; k < rtype; k++) {
                    if (avaliable[k] == 0)
                        flag11 = true;
                    else {
                        flag11 = false;
                        break;
                    }
                }
                if (flag11) {
                    System.out.println("此时已无资源课分配");
                    return;
                } else {
                    System.out.println("是否还继续? Y/N");
                    if (scanner.next().equals("Y"))
                        isContinue();
                    else
                        return;
                }
            }
            if (flag2) {
                for (int j = 0; j < rtype; j++) {
                    avaliable[j] -= request[j];
                    allocation[r][j] += request[j];
                    need[r][j] -= request[j];
                }
                boolean rflag = isSecurity(r);
                System.out.println("此时的可用资源数为: ");
                for (int j = 0; j < rtype; j++) {
                    System.out.print(avaliable[j] + "\t");
                }
                System.out.println();
                System.out.println("此时P" + r + "的资源分配情况为:");
                for (int j = 0; j < rtype; j++) {
                    System.out.print(allocation[r][j] + "\t");
                }
                System.out.println();
                System.out.println("此时P"+r+"的资源需求情况为:");
                for(int j = 0; j < rtype; j++){
                    System.out.print(need[r][j]+"\t");
                }
                System.out.println();
                if (rflag == false) {           //代表不安全,回收
                    for (int j = 0; j < rtype; j++) {
                        avaliable[j] += request[j];
                        allocation[r][j] -= request[j];
                        need[r][j] += request[j];
                        finish[r] = false;
                    }
                    display();
                    boolean flag4 = false;//代表此时是否还有资源
                    for (int j = 0; j < rtype; j++) {
                        if (avaliable[j] == 0)
                            flag4 = true;
                        else {
                            flag4 = false;
                            break;
                        }
                    }
                    if (flag4) {
                        System.out.println("此时已无资源可分配:");
                        return;
                    } else {
                        System.out.println("是否还继续? Y/N");
                        if (Objects.equals(scanner.nextInt(), "Y")) {
                            isContinue();
                        } else
                            return;
                    }
                } else {//代表此时安全,分配成功
                    boolean flag3 = false;//代表此时是否还有资源
                    for (int i = 0; i < rtype; i++) {
                        if (avaliable[i] == 0)
                            flag3 = true;
                        else {
                            flag3 = false; //此时还有可利用的资源
                            break;
                        }
                    }
                    if (flag3) {
                        System.out.println("此时已无资源可分配");
                        return;
                    } else {
                        System.out.println("是否继续? Y/N");
                        if (Objects.equals(scanner.nextInt(), "Y"))
                            isContinue();
                        else
                            return;
                    }
                }
            }
    }

    public static void main(String[] args) {
        Process p = new Process();
        p.resource();
        p.iniship();
        p.isSecurity(0);
        p.isContinue();
    }
}
