import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    //HTTP底层基于TCP来实现按照TCP基本格式进行开发
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        //工厂模式：当创建一个实例的时候，如果创建过程比较复杂，此时就可以吧这个new
        //操作封装到一个专门的的静态方法中，用这个静态方法辅助进行实例化和
        //初始化过程，这个方法也叫工厂方法
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
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //这些操作都要按照HTTP协议进行操作
            //解析首行
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            //解析header,按行读取，然后按照冒号空格来分割键值对
            Map<String,String> headers = new HashMap<>();
            String line = "";
            //readLine读取一行内容，会自动去掉换行符，对于空行来说去掉换行符，就变成了了空字符串
            while ((line = bufferedReader.readLine())!= null&&line.length() != 0) {
                //用冒号空格来切分，不能只用冒号
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0],headerTokens[1]);
            }
            //解析body（先不考虑）
            System.out.printf("%s %s %s\n",method,url,version);
            for(Map.Entry<String,String> entry:headers.entrySet()) {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
            System.out.println();
            //根据请求计算响应
            //把响应写回到客户端
            String resp = "";
            if (url.equals("/ok")) {
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>hello</h1>";
            }else if (url.equals("/notfound")) {
                bufferedWriter.write(version+" 404 Not Found\n");
                resp = "<h1>not found</h1>";
            }else if(url.equals("/seeother")) {
                bufferedWriter.write(version+" 303 See Other\n");
                bufferedWriter.write("Location: http://www.sogou.com\n");
                resp = "";
            } else {

                    bufferedWriter.write(version+" 200 OK\n");
                    resp = "<h1>default</h1>";
                }



            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-Length: "+resp.getBytes().length+"\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            bufferedWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

            //因为这里是短连接
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 serverV1 = new HttpServerV1(9090);
        serverV1.start();
    }
}
