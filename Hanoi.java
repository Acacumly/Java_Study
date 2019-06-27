import javax.swing.JOptionPane;
public class Hanoi {
	private static final String DISK_B = "diskB";
	private static final String DISK_C = "diskC";
	private static final String DISK_A = "diskA";
	static String from = DISK_A;static String to=DISK_C;
	static String mid = DISK_B;
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("please input the number of the disks you want me move.");
		int num = Integer.parseInt(input);
		move(num, from, mid, to);
	}
	private static void move(int num, String from2, String mid2, String to2) {
		if(num == 1){
			System.out.println("move disk 1 from " + from2 + " to " + to2);
		}	else {
			move(num-1, from2, to2, mid2);
			System.out.println("move disk " + num + " from " + from2 + " to " + to2);
			move(num-1, mid2, from2, to2);
		}
	}
}
