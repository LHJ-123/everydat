import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {
    private ServerSocket serverSocket = null;
    public HttpServerV2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        try {
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeader("Content-Type","text/html");
            if (request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>hello</h1>");
            }else if(request.getUrl().startsWith("/cookie")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Set-Cookie","I am cookie");
                response.writeBody("<h1>set cookie</h1>");
            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>set cookie</h1>");
            }
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV2 httpServerV2 = new HttpServerV2(9090);
        httpServerV2.start();
    }
}
