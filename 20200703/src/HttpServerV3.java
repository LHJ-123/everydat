import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class User {
    public String userName;
    public int age;
    public String school;
}
public class HttpServerV3 {
    private ServerSocket serverSocket = null;
    private HashMap<String,User> sessions = new HashMap<String, User>();
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
            //System.out.println("userName: "+userName);
            //System.out.println("password: "+password);
            if("tz".equals(userName)&&"123".equals(password)) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type","text/html; charset=utf-8");
                // response.setHeader("Set-Cookie","userName=" +userName);
               String sessionId = UUID.randomUUID().toString();
               User user = new User();
               user.userName = "lhj";
               user.age = 21;
               user.school = "啥科大";
               sessions.put(sessionId,user);
               response.setHeader("Set-Cookie","sessionId="+sessionId);
                response.writeBody("<html>");
                response.writeBody("<div>欢迎你! "+userName+"</div>");
                response.writeBody("</html>");
            }else {
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeader("Content-Type","text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>登录失败</div>");
                response.writeBody("</html>");
            }
        }

    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        if (request.getUrl().startsWith("/index.html")) {
            String sessionId = request.getCookie("sessionId");
            User user = sessions.get(sessionId);
            if (sessionId == null&&user == null) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type","text/html; charset=utf-8");
                InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("haha.html");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = bufferedReader.readLine())!=null) {
                    response.writeBody(line+"\n");
                }
                bufferedReader.close();
            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type","text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("您已经登录成功无需重复登录");
                response.writeBody("</html>");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 serverV3 = new HttpServerV3(9090);
        serverV3.start();
    }
}
