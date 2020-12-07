import java.math.BigInteger;


public class Main2 {
    public static String AddLongInteger(String addend,String augend) {
        if (addend == null ||addend.length() == 0 && augend == null||augend.length() == 0) {
            return null;
        }
        BigInteger bigInteger = new BigInteger(addend);
        BigInteger bigInteger1 = new BigInteger(augend);
        String i = String.valueOf(bigInteger.add(bigInteger1));
        return i;
    }

    public static void main(String[] args) {
        System.out.println(AddLongInteger("","212111111111111111111111111111111"));
    }
}
