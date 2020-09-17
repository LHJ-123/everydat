public class Null{
    public static void print(){
        System.out.println("MTDP");
    }
    public static void main(String[] args) {
        try{
            ((Null)null).print();
        }catch(NullPointerException e){
            System.out.println("NullPointerException");
        }
    }
}
