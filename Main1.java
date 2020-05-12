package Practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,m;
        while(sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            int[] p = new int[n];
            int[][] num = new int[m][2];
            for(int i=0;i<n;i++){
                p[i] = sc.nextInt();
            }
            Arrays.sort(p);
            int k=0;
            for(int i=0;i<m;i++){
                num[k][0] = sc.nextInt();
                num[k][1] = sc.nextInt();
                if(p[n-1]>=num[k][0]){
                    k++;
                }
            }
            Arrays.sort(num,0,k,new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return b[1]-a[1];
                }
            });
            boolean[] isSelect = new boolean[n];
            long sum = 0;
            int index = 0;
            for(int i=0;i<k;i++){
                index = findTable(p, num[i][0]);
                while(index<n && isSelect[index])index++;
                if(index<n){
                    sum += num[i][1];
                    isSelect[index] = true;
                }
            }
            System.out.println(sum);
        }
    }
    public static int findTable(int[] table, int people){
        int i=0,j=table.length-1;
        int index = (i+j)/2;
        while(i<=j){
            if(table[index]>=people){
                j = index - 1;
            }else{
                i = index + 1;
            }
            index = (i+j)/2;
        }
        if(table[index]<people)index++;
        return index;
    }
}