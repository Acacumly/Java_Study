import java.util.Random;
class Demo_Random{
	public static void main(String[] args){
		Random random=new Random();
		//����int���͵����������Χ��1-6
		int value=random.nextInt(6)+1;
		System.out.println("����һ�� "+value+" ��");
	}
}