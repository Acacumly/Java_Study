import java.util.Arrays;
public class MultiArrayTest {
	public static void main(String[] args) {
		int a[][]=new int[5][5];
		
		long currTime=System.currentTimeMillis();
		for (int i=0;i<5;i++)
			for (int j=0;j<5;j++)
				a[i][j]=i+j;
		System.out.println(Arrays.deepToString(a));
		for (int[] i:a)
			for (int j:i)
		System.out.print(j +" ");
	}
}
