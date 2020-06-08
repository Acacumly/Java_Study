import java.util.Random;
class Demo_Random{
	public static void main(String[] args){
		Random random=new Random();
		//产生int类型的随机数，范围：1-6
		int value=random.nextInt(6)+1;
		System.out.println("掷了一个 "+value+" 点");
	}
}