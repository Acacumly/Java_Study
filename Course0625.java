//一球从100米高度自由落下，每次落地后反跳回原高度的一半；
//再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
public class Course0625 {
	public static void main(String[] args) {
		int total = 0;
		int height = 100;
		for (int i = 0; i < 10; i++) {
			System.out.print("第" + (i + 1) + "次落下时候高度:" + height + " ");
			total = total + height;
			height = height / 2;
			System.out.println("第" + (i + 1) + "次落下经过距离:" + total);
		}
	}

}