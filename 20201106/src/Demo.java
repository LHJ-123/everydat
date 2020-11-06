import java.util.Scanner;

class IDCard {
    private String _ID;

    public IDCard(String ID){
        setID(ID);
    }

    public void setID(String ID) {
        _ID = ID;
    }

    public void judgePlace(){
        char ch = _ID.charAt(16);
        String str = _ID.substring(0, 6);

        if (str.equals("610112")){
            if (ch % 2 != 0){
                System.out.println("是陕西省西安市未央区的男性");
            }else{
                System.out.println("是陕西省西安市未央区的女性");
            }
        }else{
            System.out.println("不是陕西省西安市未央区的");
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入身份证号:");
        String ID = sc.nextLine();
        sc.close();
        IDCard id = new IDCard(ID);
        id.judgePlace();
    }
}
