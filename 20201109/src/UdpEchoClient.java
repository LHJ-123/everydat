import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    String serverIp = null;
    int port ;

    public UdpEchoClient(String serverIp, int port) throws SocketException {
        this.serverIp = serverIp;
        this.port = port;
        socket = new DatagramSocket();
    }
    private void start() throws IOException {
        System.out.println("-> ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            if ("exit".equals(request)) {
                break;
            }
            DatagramPacket req = new DatagramPacket(request.getBytes(),request.getBytes().length, InetAddress.getByName(serverIp),port);
            socket.send(req);
            DatagramPacket resp = new DatagramPacket(new byte[4096],4096);
            socket.receive(resp);
            String response = new String(resp.getData(),0,resp.getLength()).trim();
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }

}
