import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    static class User{
        public String username;
        public int age;
        public String school;
    }
    private ServerSocket serverSocket = null;
    private HashMap<String,User> sessions = new HashMap<>();

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
            if (request.getMethod().equalsIgnoreCase("GET")) {
                doGet(request, response);
            } else if (request.getMethod().equalsIgnoreCase("POST")) {
                doPost(request, response);
            } else {
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) throws IOException {
        if (request.getUrl().startsWith("/login")) {
            String userName = request.getParameters("username");
            String password = request.getParameters("password");
            if (userName.equals("lhj") && password.equals("123")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                //response.setHeaders("Set-Cookie","username="+userName);
                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.username = "lhj";
                user.age = 22;
                user.school = "你好";
                sessions.put(sessionId,user);
                response.setHeaders("Set-Cookie","sessionId="+sessionId);
                response.writeBody("<html>");
                response.writeBody("<h1>欢迎您" + userName + "</h1>");
                response.writeBody("</html>");
            } else {
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<h1>登录失败</h1>");
                response.writeBody("</html>");
            }
        }
    }


        private void doGet(HttpRequest request, HttpResponse response) throws IOException {
            if (request.getUrl().startsWith("/index.html")) {
                String sessionId= request.getCookies("sessionId");
                User user = sessions.get(sessionId);
                if (sessionId == null || user == null) {
                    InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        response.writeBody(line + "\n");
                    }
                    bufferedReader.close();
                }else {
                    response.setStatus(200);
                    response.setMessage("OK");
                    response.setHeaders("Content-Type", "text/html; charset=utf-8");
                    response.writeBody("<html>");
                    response.writeBody("<h1>欢迎您</h1>"+user.username);
                    response.writeBody("</html>");
                }
            }
        }

        public static void main (String[]args) throws IOException {
            HttpServerV3 serverV3 = new HttpServerV3(9090);
            serverV3.start();
        }
    }

