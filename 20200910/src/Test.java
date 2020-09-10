public class Test{
    private static int i = 1;
    public int getNext(){
        return i++;
    }
    public static void main(String [] args){
        Test test=new Test();
        Test testObject=new Test();
        int n = test.getNext();
        int m = testObject.getNext();
        System.out.println(n+" "+m);
        System.out.println(testObject.getNext());
    }
}