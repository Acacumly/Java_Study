/*
猜拳游戏
参与A：用户
参与B：电脑

剪刀(0)、石头(1)、布(2)

剪刀 KO 布
石头 KO 剪刀
布 KO 石头

实现思路：
1.用户出拳
 487     `	 																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					2.机器出拳
3.裁判输赢
*/
import java.util.Scanner;
import java.util.Random;
class Game{
	public static void main(String[] args){
		System.out.println("请出拳：剪刀(0)、石头(1)、布(2)");
		Scanner in=new Scanner(System.in);
		//接收用户出拳
		int user=in.nextInt();
		
		/**机器出拳*/
		Random random=new Random();
		//随机产生0、1、2数值
		int computer=random.nextInt(3);
		if(user==0&&computer==2||user==1&&computer==0||user==2&&computer==1){
			System.out.println("你赢啦");
		}else if(user==computer){
			System.out.println("平局");
		}else{
			System.out.println("你输啦！！！");
		}
		//存储机器与用户的出拳结果
		String computerText="";
		String userText="";
		switch(user){
			case 0:
				userText="剪刀";
				break;
			case 1:
				userText="石头";
				break;
			case 2:
				userText="布";
				break;
		}
		switch(computer){
			case 0:
				computerText="剪刀";
				break;
			case 1:
				computerText="石头";
				break;
			case 2:
				computerText="布";
				break;
		}
		System.out.println("用户："+userText+"	机器："+computerText);
	}	
}