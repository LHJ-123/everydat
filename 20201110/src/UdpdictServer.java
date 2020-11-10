import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpdictServer extends UdpEchoServer {
    Map<String,String> dict = new HashMap<>();
    public UdpdictServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("bird","小鸟");
        dict.put("pig","小猪");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"这超出了我的知识范围");
    }

    public static void main(String[] args) throws IOException {
        UdpdictServer udpdictServer = new UdpdictServer(9090);
        udpdictServer.start();
    }
}
