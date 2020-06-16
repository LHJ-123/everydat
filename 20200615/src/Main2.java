

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static String AddLongInteger(String addend,String augend){

        BigInteger bigInteger = new BigInteger(addend);
        BigInteger bigInteger1 = new BigInteger(augend);

        bigInteger = bigInteger.add(bigInteger1);
        String str = String.valueOf(bigInteger);
        return str;


    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String addend = sc.nextLine();
            String augend = sc.nextLine();
            System.out.println(AddLongInteger(addend, augend));
        }


    }
}
