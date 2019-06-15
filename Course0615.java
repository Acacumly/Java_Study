class Course0615 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int d=1;
        while(x/d>=10) { 
			d*=10;//计算有多少位的一个整数
		}
		while(x>0){
            int q = x/d;//得到最高位
            int r = x%10;//得到最低位
            if(q!=r) return false;
            x=x%d/10;//得到最高和最低之间的位
            d/=100;
        }
        return true;
    }
}