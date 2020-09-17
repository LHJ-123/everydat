public class Demo {
    public static void mulTable2(int n) {
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=i;j++) {
                System.out.print(i+"x"+j+"="+i*j+" ");
            }
            System.out.println();
        }

    }
    public static void mulTable(int n) {
       int i = 1;
       int j = 1;
       while (i<=n) {
           while (j<=i) {
               System.out.print(i+"x"+j+"="+i*j+" ");
               j++;
           }
           i++;
           j = 1;
           System.out.println();
       }
    }

    public static void main(String[] args) {
           //mulTable(9);
       // mulTable1(9);
    }
}
