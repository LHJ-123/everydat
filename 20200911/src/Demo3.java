public class Demo3 {
    public int countNumberOf2s(int n) {
        int count = 0;
        int factor = 1;
        int low = 0;
        int current = 0;
        int high = 0;
        while (n/factor != 0) {
            low = n-(n/factor)*factor;
            current = (n/factor)%10;
            high = n/(factor*10);
            switch (current) {
                case 0:
                case 1:
                    count += high*factor;
                    break;
                case 2:
                    count += high*factor+low+1;
                    break;
                default:
                    count += (high+1)*factor;
                    break;
            }
            factor *= 10;
        }
        return count;
    }
}
