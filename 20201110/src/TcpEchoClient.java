import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    Socket socket = null;

    public TcpEchoClient(String serverIp,int port) throws IOException {
        socket = new Socket(serverIp,port);
    }

    public void start() {
        System.out.println("客户端启动");
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("->");
                String request = scanner.nextLine();
                if ("exit".equals(request)) {
                    break;
                }
                bufferedWriter.write(request+"\n");
                bufferedWriter.flush();
                String response = bufferedReader.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
