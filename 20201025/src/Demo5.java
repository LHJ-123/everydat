class TestPrivateNum {
   public void addI(String username) {
       try {
           int num = 0;
           if (username.equals("a")) {
               num = 100;
               System.out.println("a set over");
               Thread.sleep(2000);
           }else {
               num = 200;
               System.out.println("b set over");
           }
           System.out.println(username+" num="+num);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
class ThreadC extends Thread {
    private TestPrivateNum privateNum;

    public ThreadC(TestPrivateNum privateNum) {
        super();
        this.privateNum = privateNum;
    }

    @Override
    public void run() {
        super.run();
        privateNum.addI("a");
    }
}
class ThreadD extends Thread {
    private TestPrivateNum privateNum;

    public ThreadD(TestPrivateNum privateNum) {
        super();
        this.privateNum = privateNum;
    }

    @Override
    public void run() {
        super.run();
        privateNum.addI("b");
    }
}
public class Demo5 {
    public static void main(String[] args) {
        TestPrivateNum privateNum = new TestPrivateNum();
        ThreadC threadC = new ThreadC(privateNum);
        threadC.start();
        ThreadD threadD = new ThreadD(privateNum);
        threadD.start();
    }
}
