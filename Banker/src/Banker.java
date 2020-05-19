import java.util.Scanner;

public class Banker {
    static int S = 0;  //用来控制检测安全序列的变量
    static void Alloctionadd(Resource res,Process pro){
        Resource cur = res;
        int i = 1;
        while(cur!=null){
            Process tmp = pro;
            int count = 0;
            while(tmp!=null){
                Resource tmp2 = tmp.already;
                for(int j=1; j<i; j++){
                    tmp2 = tmp2.rNext;
                }
                count += tmp2.num;
                tmp = tmp.pNext;
            }
            cur.Available = cur.num-count;
            cur = cur.rNext;
            i++;
        }
    }
    static Resource addResource(Resource res,String str,int num){
        if(res == null){
            res = new Resource(str,num);
            return res;
        }
        Resource cur = res;
        while(cur.rNext!=null){
            cur = cur.rNext;
        }
        cur.rNext = new Resource(str,num);
        return res;
    }
    static Resource InitResource(){
        Resource res = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("资源的数量为：");
        int a=sc.nextInt();
        System.out.println("请输入"+a+"个资源的名称和总数");
        for(int i=1; i<=a; i++){
            //System.out.println("第"+i+"个资源的名称和总数：");
            String b=sc.next();
            int c=sc.nextInt();
            res = addResource(res,b,c);
        }
        return res;
    }

    //输入进程的数量
    static Process addProcess(Process pro,String str){
        if(pro == null){
            pro = new Process(str);
            return pro;
        }
        Process cur = pro;
        while(cur.pNext!=null){
            cur = cur.pNext;
        }
        cur.pNext = new Process(str);
        return pro;
    }
    static Process InitProcess(int num){
        Process pro = null;
        for(int i=0; i<num; i++){
            pro = addProcess(pro,"P"+i);
        }
        return pro;
    }
    //进程最大需求资源个数
    static void MaxNeed(Process pro,Resource res){
        Scanner sc = new Scanner(System.in);
        Resource cur2 = null;
        Process cur = pro;
        while(cur!=null){
            int i = 1;
            cur2 = res;
            while(cur2!=null){
                System.out.println(cur.name+"进程的第"+i+"个资源的最大需求量是：");
                int num = sc.nextInt();
                cur.maxNeed = addResource(cur.maxNeed,cur2.name,num);
                cur2 = cur2.rNext;
                i++;
            }
            cur = cur.pNext;
        }
    }
    //t0时刻已经分配的资源
    static void Already(Process pro,Resource res){
        Scanner sc = new Scanner(System.in);
        Resource cur2 = null;
        Process cur = pro;
        while(cur!=null){
            int i = 1;
            cur2 = res;
            while(cur2!=null){
                System.out.println(cur.name+"进程的第"+i+"个资源的已经分配量是：");
                int num = sc.nextInt();
                cur.already = addResource(cur.already,cur2.name,num);
                cur2 = cur2.rNext;
                i++;
            }
            cur = cur.pNext;
        }
    }
    //安全性检测
    static Process copyProcess(Process pro){
        Process pro2 = null;
        Process cur = pro;
        while(cur!=null){
            pro2 = addProcess(pro2,cur.name);
            cur = cur.pNext;
        }
        Process cur2 = pro2;
        cur = pro;
        while(cur!=null){
            cur2.already = copyResource(cur.already,pro2);
            cur2.maxNeed = copyResource(cur.maxNeed,pro2);
            cur2 = cur2.pNext;
            cur = cur.pNext;
        }
        return pro2;
    }
    static Resource copyResource(Resource res,Process pro){
        Resource res2 = null;
        Resource cur = res;
        while(cur!=null){
            res2 = addResource(res2,cur.name,cur.num);
            cur = cur.rNext;
        }
        cur = res;
        Resource cur2 = res2;
        while(cur!=null){
            cur2.Available = cur.Available;
            cur = cur.rNext;
            cur2 = cur2.rNext;
        }
        return res2;
    }
    //判断当前进程链表中是否有符合条件的进程
    static Process IsSecurity(Process pro,Resource res){
        Process cur1 = pro;//进程结点
        Process pre = cur1;//传入进程链表
        Resource cur2 = null;
        while(cur1!=null){
            Resource tmp1 = cur1.maxNeed;
            Resource tmp2 = cur1.already;
            cur2 = res;
            while(cur2!=null){//资源结点
                if(cur2.Available < tmp1.num - tmp2.num){ // 可用资源是否小于 需要资源
                    break;
                }
                tmp1 = tmp1.rNext;
                tmp2 = tmp2.rNext;
                cur2 = cur2.rNext;
            }
            if(cur2 == null){  //走完了所有资源 都满足需求
                cur2 = res;
                tmp2 = cur1.already;
                while(cur2!=null){
                    cur2.Available += tmp2.num;
                    cur2 = cur2.rNext;
                    tmp2 = tmp2.rNext;
                }
                System.out.print(cur1.name+" ");
                return pre;
            }
            pre = cur1;
            cur1 = cur1.pNext;
            S++;
        }
        return null;
    }
    static int SecurityCheck(Process pro,Resource res){
        Process pro2 = copyProcess(pro);//赋值
        Resource res2 = copyResource(res,pro2);
        while(pro2!=null) {
            S = 0;
            Process pre = IsSecurity(pro2, res2);
            if(pre == null){
                System.out.println("没有安全序列!!");
                return 0;
            }
            if(pre == pro2 && S == 0){  //T如果没+过  说明返回的是头节点
                pro2 = pro2.pNext;
                continue;
            }
            pre.pNext = pre.pNext.pNext;
        }
        return 1;
    }
    //开始请求资源
    static int NewRequires(Process pro,Resource res){
        int count = 0;//标记系统request+allocation
        Scanner sc = new Scanner(System.in);
        Process pro2 = copyProcess(pro);
        Resource res2 = copyResource(res,pro2);
        Resource tmp = res2;
        System.out.println("第几个进程需要请求资源？");
        int a=sc.nextInt();
        Process cur = pro2;
        for(int i=1; i<a; i++){
            cur = cur.pNext;
        }
        Resource already2 = cur.already;
        Resource max = cur.maxNeed;
        for(int j=1; already2!=null; j++){
            System.out.println("请输入第"+j+"个资源新请求的个数:");
            int b=sc.nextInt();
            already2.num += b;
            if(already2.num > max.num){
                System.out.println("请求超出最大资源需求，请求出错！");
                return 0;
            }
            tmp.Available -= b;
            if(tmp.Available < 0){
                System.out.println("已有资源"+tmp.name+"不足，请求错误！");
                return 0;
            }
            tmp = tmp.rNext;
            max = max.rNext;
            already2 = already2.rNext;
        }
        Resource cur3 = res;
        cur = pro;
        Process cur1 = pro2;
        Process pre = null;
        for(int i=1; i<a; i++){
            pre = cur;
            cur = cur.pNext;
            cur1 = cur1.pNext;
        }
        Resource already = cur.already;

        if(SecurityCheck(pro2,res2) == 1) {
            while (res2 != null) {
                cur3.Available = res2.Available;
                already.num = cur1.already.num;
                if(already.num != cur1.maxNeed.num){
                    count = 1;
                }
                cur3 = cur3.rNext;
                res2 = res2.rNext;
                already = already.rNext;
                cur1.already = cur1.already.rNext;
                cur1.maxNeed = cur1.maxNeed.rNext;
            }
            if(count == 0){
                cur3 = res;
                already = cur.already;
                while(cur3!=null){
                    cur3.Available += already.num;
                    cur3 = cur3.rNext;
                    already = already.rNext;
                }
                if(pre == null){
                    return 1;
                }else{
                    pre.pNext = pre.pNext.pNext;
                }
            }
        }
        return 0;
    }

    //查看进程和资源
    static void check(Resource res,Process pro){
        Resource cur = res;
        Process cur2 = pro;
        System.out.println("系统每个资源的总数\t\t"+"可用资源数(available)");
        while(cur!=null){
            System.out.println(cur.name+"\t\t\t"+cur.num+"\t\t\t"+cur.Available);
            cur = cur.rNext;
        }
        System.out.println("系统每个进程的信息");
        while(cur2!=null){
            System.out.print(cur2.name+" | ");
            Resource cur3 = cur2.maxNeed;
            System.out.print("各资源最大需求数|");
            while(cur3!=null){
                System.out.print(cur3.num+"\t\t");
                cur3 = cur3.rNext;
            }
            System.out.print("\t\t资源当前拥有数 |");

            cur3 = cur2.already;
            while(cur3 !=null){
                System.out.print(cur3.num+"\t\t");
                cur3 = cur3.rNext;
            }
            cur2 = cur2.pNext;
            System.out.println();
        }
    }

    /*
   输出界面
   进行选择操作
   1.进行设置资源种类数
   2.进行设置进程种类数
   3.输入进程的最大需求矩阵
   4.输入T0时刻的每个进程已分配的资源数
   5.安全性检测
   6.开始进行资源请求
   7.查看当前系统的资源和进程情况
   0.退出
   请输入你的选择
   */
    static void menu(){
        Scanner sc = new Scanner(System.in);
        Resource res = null;
        Process pro = null;
        int a = 1;
        while(a!=0)
        {
            System.out.println("1.输入资源的种类和数量");
            System.out.println("2.输入进程的数量");
            System.out.println("3.输入每个进程的最大需求个数");
            System.out.println("4.输入t0时刻每个进程已经分配的资源个数");
            System.out.println("5.安全性检测");
            System.out.println("6.开始请求资源");
            System.out.println("7.查看当前系统的资源和进程");
            System.out.println("0.退出程序");
            System.out.println("请输入选择：");
            a=sc.nextInt();
            switch(a){
                case 1:
                    res = InitResource();
                    break;
                case 2:
                    System.out.println("进程的总个数为：");
                    int num = sc.nextInt();
                    pro = InitProcess(num);
                    break;
                case 3:
                    MaxNeed(pro,res);
                    break;
                case 4:
                    Already(pro,res);
                    Alloctionadd(res,pro);
                    break;
                case 5:
                    SecurityCheck(pro,res);
                    System.out.println();
                    break;
                case 6:
                    if(NewRequires(pro,res) == 1){
                        pro = pro.pNext;
                    }
                    break;
                case 7:
                    check(res,pro);
                    break;
                case 0:
                    System.out.println("正常退出！");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
