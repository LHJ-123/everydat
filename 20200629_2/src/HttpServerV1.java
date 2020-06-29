import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
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
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            Map<String,String> headers = new HashMap<>();
            String line = "";
            while ((line = bufferedReader.readLine())!=null&&line.length()!=0) {
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0],headerTokens[1]);
            }
            System.out.printf("%s %s %s\n",method,url,version);
            for (Map.Entry<String,String> entry:headers.entrySet()) {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
            System.out.println();
            String resp = "";
            if (url.equals("/ok")) {
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>hello</h1>";
            }else if(url.equals("/notfound")) {
                bufferedWriter.write(version+" 404 Not Found\n");
                resp = "<h1>not found</h1>";
            }else if(url.equals("/seeother")) {
                bufferedWriter.write(version+" 303 See Other\n");
                bufferedWriter.write("Location: http://sogou.com\n");
                resp = "";
            }else {
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>default</h1>";
            }
            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-Length:"+resp.getBytes().length+"\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            bufferedWriter.flush();
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
        HttpServerV1 serverV1 = new HttpServerV1(9090);
        serverV1.start();
    }
}
