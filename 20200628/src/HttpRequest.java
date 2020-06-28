import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();
//本质就是在“反序列化”；把比特流转化为结构化数据
    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        //此处不能把这个写到try里，否则就会被关闭，影响clientSocket状态
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        int pos = request.url.indexOf("?");
        if(pos!=-1) {
            String parameters = request.url.substring(pos+1);
            parseKV(parameters,request.parameters);
        }
        String line = "";
        while ((line = bufferedReader.readLine())!=null&&line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        return request;

    }

    private static void parseKV(String input, Map<String, String> output) {
         String[] kvTokens = input.split("&");
         for (String kv:kvTokens) {
             String[] result = kv.split("=");
             output.put(result[0],result[1]);
         }
    }
    //构造方法

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }
    public String getHeader(String key) {
        return headers.get(key);
    }
    public String getParameter(String key) {
        return parameters.get(key);
    }

}
