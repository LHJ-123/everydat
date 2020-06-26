import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    //a.启动客户端(和服务器建立连接）
    //b.进入主循环
    //1.读取用户输入内容
    //2.构造请求发送给服务器
    //3.读取响应
    //4.吧响应显示在界面
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
    }
    public void start() {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                System.out.print("->");
                String request = scanner.nextLine();
                if (request.equals("exit")) {
                    break;
                }
                //构造请求并发送
                bufferedWriter.write(request+"\n");
                //write操作只是写到了内存的缓冲区里面并没有真正往内核socket中写
                //注意这里的缓冲区刷新操作
                //调用flush才真正把内容写到socket里
                bufferedWriter.flush();
                //读取响应
                //请求和响应格式不一定相同
                String response = bufferedReader.readLine();
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
