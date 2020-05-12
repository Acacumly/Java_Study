package Practice;

import java.util.Scanner;

class Line{
    public Line(){
        visited=false;
        time=Integer.MAX_VALUE;
    }
    public void set(int t,int b,int e){
        this.begin=b;
        this.end=e;
        this.time=t;
    }
    boolean visited;
    int begin;
    int end;
    int time;
}
public class Main2{
    public static int dijkstra(Line[][] lines,int n) {
        int[] time=new int[n+1];
        for (int i=2;i<=n;i++) {
            if(lines[1][i].time<lines[1][i].begin)
                time[i]=lines[1][i].time;
            else
                time[i]=lines[1][i].time+lines[1][i].end;
        }
        time[1]=1;
        lines[1][1].visited=true;
        int v=1;
        while (v!=n) {
            int minTime=Integer.MAX_VALUE;
            v=1;
            for(int j=1;j<=n;j++)
            {
                if(!lines[j][j].visited&&time[j]<minTime)
                {
                    minTime=time[j];
                    v=j;
                }
            }
            lines[v][v].visited=true;
            for(int j=2;j<=n;j++)
            {
                if(!lines[j][j].visited&&lines[v][j].time<Integer.MAX_VALUE){
                    int tmp;
                    if(lines[v][j].time+time[v]<lines[v][j].begin||time[v]>lines[v][j].end)
                    {
                        tmp=lines[v][j].time+time[v];
                    }
                    else
                        tmp=lines[v][j].end+lines[v][j].time;
                    time[j]=time[j]<tmp?time[j]:tmp;
                }
            }
        }
        return time[n]+1;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            Line[][] lines=new Line[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    lines[i][j]=new Line();
                }
            }
            for (int i=0;i<m;i++) {
                int p=sc.nextInt();
                int q=sc.nextInt();
                int t=sc.nextInt();
                int b=sc.nextInt();
                int e=sc.nextInt();
                lines[p][q].set(t,b,e);
                lines[q][p]=lines[p][q];
            }
            System.out.println(dijkstra(lines,n));
        }
    }

}