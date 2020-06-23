import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class TcpEchoServer {
    //1.初始化服务器
    //2.进入主循环
    //3.先去从内核中获取到一个TCP连接
    //4.处理这个TCP连接
    //5.读取请求并解析
    //6.根据请求计算响应
    //7.把响应写回给客户端
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //获取连接(有操作系统内核管理）
            //调用accept就是从阻塞队列取出一个连接对象，就是Socket对象
            Socket clientSocket = serverSocket.accept();
            //处理连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
         try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
             ; BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){

         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
