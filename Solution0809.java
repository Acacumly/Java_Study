import java.util.Scanner;
public class Solution0809 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        if(st.trim().length()>0 ){
            findChar(st);
        }
    }
    public static void findChar(String st){
        char[] ch=new char[256];
        for(int i=0;i<st.length();i++) {
            ch[st.charAt(i)]++;
        }
        for(int i=0;i<st.length();i++){
            if(ch[st.charAt(i)]==1){
                System.out.println(st.charAt(i));
                break;
            }
            if(ch[st.charAt(i)]!=1 && i==st.length()-1 ){
                System.out.println("-1");
            }
        }
    }
}
