import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //对于一个服务器，核心流程为两步
    //1.初始化操作（实例化Socket对象）
    //2.进入主循环，接受并处理请求
    //读取数据并解析
    //根据请求计算响应
    //吧响应结果返回到客户端
    private DatagramSocket socket = null;
    //绑定端口号
    //构造Socket时如果没写IP，默认是0.0.0.0（特殊IP）会关联到这个主机的所有网卡IP
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //UDP socket发送接受数据的基本单位
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            //当客户端没发任何数据，receive就会阻塞
            socket.receive(requestPacket);
            //当有客户端数据过来了，receive就会把数据放到DatagramPacket对象的缓冲区
            //吧数据转成String
            //用户实际发送的数据可能远小于4096，而此处得到的长度就是4096，
            //可以通过trim就可以去掉不必要的空白字符
            String request = new String(requestPacket.getData(),
                    0,requestPacket.getLength()).trim();
            String response = process(request);
            //requestPacket.getSocketAddress()就是客户端的地址和端口
            //response.getBytes().length得到的是字节数
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(requestPacket);
            System.out.printf("[%s:%d] req: %s;resp:%s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    public String process(String request) {
        //此处是回显服务器，请求啥响应内容就是啥
        //如果是更复杂的服务器，此处就包含很多业务逻辑
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}