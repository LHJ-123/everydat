import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        //进入主循环
        //先创建一个线程池
        //工厂模式
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
           //获取内核连接
            //一个服务器只能连接到一个客户端只有当前客户端退出后，才能继续调用accept
            //此处用多线程来解决这个问题
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
            //处理连接
         /*   Thread thread = new Thread() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            thread.start();*/

        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //获取clientSocket中的流对象
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //客户端和服务器有时并不是只交互一次
            //这时服务器处理的方式
            //（短连接）1.一个连接客户端和服务器只交互一次完毕之后就断开连接
            //（长连接）2.一个连接中客户端和服务器交互N次，直到满足一定条件再断开连接
            //当客户端断开连接，循环就结束啦
            //当断开连接，readLine或者write就会触发异常
            //此处为长连接
            while (true) {
                //客户端发送的数据必须按行
                String request = bufferedReader.readLine();
                String response = process(request);
                bufferedWriter.write(response+"\n");
                System.out.printf("[%s:%d] req: %s;resp %s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            System.out.printf("[%s:%d] 客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
