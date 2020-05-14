package Practice;

import java.util.Scanner;

public class Main3 {
    /**
     * 矩阵乘法
     * @param A
     * @param B
     * @return
     */
    static long MAX = (long) (1e9 + 7);
    static long[][] dot(long[][] A, long[][] B) {
        assert (A[0].length == B.length);
        long tmp;
        long[][] R = new long[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    R[i][j]+= A[i][k]* B[k][j];
                }
                R[i][j] = (long) (R[i][j]%MAX);
            }

        }
        return R;
    }

    /**
     * 矩阵快速幂模
     * @param a
     * @param b
     * @return
     */
    public static long[][] quickMod(long[][] a, long b) {
        long[][] ans = new long[3][3];
        b=b-3;
        //初始化为单位矩阵
        for(int i=0;i<3 ;++i) {
            ans[i][i] = 1;
        }
        //计算矩阵乘法
        while (b != 0) {
            if ((1 & b) == 1) {
                ans = dot(ans, a);
            }
            b >>= 1;
            a = dot(a , a) ;
        }
        return ans;
    }


    /**
     * 斐波那契通用公式：
     * {F(n),F(n-1),F(n-2)} = {{1, 0，1}, {1,0， 0}，{0，1，0}}^(n-3) *  {F(3),F(2)，F(1)}
     * @param args
     */
    public static void main(String[] args) {
        long[][] A = new long[][]{{1, 0,1}, {1, 0,0},{0, 1,0}};
        long[][] B = new long[3][3];
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n > 3) {
            B= quickMod(A,n);
            long rs = (long) (3*B[0][0]+2*B[0][1]+B[0][2])%MAX;
            System.out.println(rs);
        } else {
            System.out.println(n);
        }

    }
}