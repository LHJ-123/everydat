public class Main2 {
    public static int calcSimilarity(String name1, String name2) {
        if (name1 == null&&name2 == null) {
            return 0;
        }
        String[] arr1 = name1.split(" ");
        String[] arr2 = name2.split(" ");
        int minL = arr1.length>=arr2.length?arr2.length:arr1.length;
        int count = 0;
        for (int i = 0;i<minL;i++) {
            String s1 = arr1[i];
            String s2 = arr2[i];
            int cur1 = 0;
            int cur2 = 0;
            int minL2 = s1.length()>=s2.length()?s2.length():s1.length();
            for (int j = 0;j<minL2;j++){
                if (s1.charAt(cur1) == s2.charAt(cur2)) {
                    cur1++;
                    cur2++;
                    continue;
                }
                int n1 = s1.charAt(cur1);
                int n2 = s2.charAt(cur2);
                cur1++;
                cur2++;
                count = count+n1+n2;
            }
            //
            if (cur1<s1.length()) {
                for (int m = cur1;m<s1.length();m++) {
                    int x = s1.charAt(m);
                    count = count+x;
                }
            }
            if (cur2<s2.length()) {
                for (int m = cur2;m<s2.length();m++) {
                    int x = s2.charAt(m);
                    count = count+x;
                }
            }
        }
        if (arr1.length-minL>=1) {
            for (int i = minL;i<arr1.length;i++) {
                String s = arr1[i];
                for (int j = 0;j<s.length();j++) {
                    int x = s.charAt(j);
                    count = count+x;
                }
            }
        }
        if (arr2.length-minL>=1) {
            for (int i = minL;i<arr2.length;i++) {
                String s = arr1[i];
                for (int j = 0;j<s.length();j++) {
                    int x = s.charAt(j);
                    count = count+x;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = calcSimilarity("Zhang San", "Zhan Ai");
        System.out.println(i);
    }
}
