//脏读

class PublicVar {
    public String username = "A";
    public String password = "AA";
    synchronized public void setValue(String username,String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name ="+Thread.currentThread().getName()+"username="+username+"password="+password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue method thread name ="+Thread.currentThread().getName()+"username="+username+"password="+password);
    }
    synchronized public void getValue1() {
        System.out.println("getValue method thread name ="+Thread.currentThread().getName()+"username="+username+"password="+password);
    }
}
class ThreadA extends Thread {
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}
public class Demo {
    public static void main(String[] args) {
        try {
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200);//打印结果受此值的影响
            //publicVar.getValue();
            publicVar.getValue1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
