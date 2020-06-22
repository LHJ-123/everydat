import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    //客户端分四步
    //1.从用户这里读取数据
    //2.构造请求发给服务器
    //3.从服务器读取响应
    //4.吧响应写回给客户端
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    //需要在启动客户端是来指定需要连接那个服务器
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        //不需要绑定端口号，由操作系统自动分配一个空闲端口
        //一个端口号通常只能被一个进程绑定
        //服务器绑定了端口之后，客户端才能访问
        //客户端如果绑定端口，一个主机只能启动一个客户端（通常不允许）
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("->");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                break;
            }
            //构造请求
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String response = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        //这里的IP是特殊IP，环回IP，由于这里服务器和客户端在同一主机
        //如果不在同一主机，要写成服务器IP
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
