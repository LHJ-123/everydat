import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    private ServerSocket serverSocket = null;
    public HttpServerV3(int port) throws IOException {
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
               if (request.getMethod().equals("GET")) {
                   doGet(request,response);
               }else if(request.getMethod().equals("POST")) {
                   doPost(request,response);
               }else {
                   response.setStatus(405);
                   response.setMessage("Method Not Allowed");
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

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.getUrl().startsWith("/login")) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("userName: "+userName);
            System.out.println("password: "+password);
        }

    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        if (request.getUrl().startsWith("/index.html")) {
           InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("haha.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine())!=null) {
                response.writeBody(line+"\n");
            }
            bufferedReader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 serverV3 = new HttpServerV3(9090);
        serverV3.start();
    }
}
