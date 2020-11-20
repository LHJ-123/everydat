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
            //读取请求并解析
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            System.out.println(request);
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type","text/html");

            //根据请求计算响应
            //吧响应写回到客户端
            if (request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>hello</h1>");
            }else if (request.getUrl().startsWith("/calc")) {
                String aStr = request.getParameters("a");
                String bStr = request.getParameters("b");
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int result = a+b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>result = "+result+"</h1>");
            }else if (request.getUrl().startsWith("/cookie")) {
                response.setStatus(200);
                response.setMessage("OK");
                //HTTP中允许有多个Set-Cookie字段，但此处我们设置存储cookie的是哈希表，所以key值不能重复
                response.setHeaders("Set-Cookie","user=lhj; time="+System.currentTimeMillis());
                response.writeBody("<h1>set cookie</h1>");

            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>default</h1>");
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
        HttpServerV2 serverV2 = new HttpServerV2(9090);
        serverV2.start();
    }
}
