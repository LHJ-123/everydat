import java.util.*;

public class Main3 {
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0]-AB[1];
        AB[1] = AB[0]+AB[1];
        AB[0] = AB[1]-AB[0];
        return AB;
    }
}