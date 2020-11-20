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

    //此处参数就是从socket中获取到的流对象
    //解析流对象，反序列化操作
    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //解析URL
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String parameter = request.url.substring(pos+1);
            parseKV(parameter,request.parameters);
        }
        //解析header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        //解析body（暂不考虑）
        return request;
    }

    private static void parseKV(String input, Map<String, String> output) {
        String[] kvs = input.split("&");
        for (String kv:kvs) {
            String[] result = kv.split("=");
            output.put(result[0],result[1]);
        }

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getHeaders(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", parameters=" + parameters +
                '}';
    }
}
