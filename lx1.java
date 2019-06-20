public class lx1 {
	
	public static int calcDigitNum(long n){
		int digitNum = 0;
		while(n > 0) {
			n = n/10;
			digitNum++;
		}
		return digitNum;
	}		
public static void main(String[] args){
		long n =Long.parseLong(args[0]);
		//System.out.println(calcDigitNum(193824));
		System.out.printf("%d---共有%d位%n",n,calcDigitNum(n));
	}
}