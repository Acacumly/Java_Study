/**
��1900�굽2020���������
���裺
1.����1900-2020֮������
2.�ж�������ƽ��
3.�ۼӸ���ݵ�������
*/
class Demo_TotalDays{
	public static void main(String[] args){
		int sum=0;
		for(int year=1900;year<=2020;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				sum=sum+366;
			}else{
				sum=sum+365;
			}
		}
		System.out.println(sum);
	}
}