import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    private static final String HOST = "localhost";
    private static final int PORT = 9999;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            // 客户端发送数据IO输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);
            // 客户端接收数据IO输入流
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            // 接收控制台输入数据
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String line = sc.nextLine();
                pw.println(line);
                String content = br.readLine();
                System.out.println("rev:"+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
