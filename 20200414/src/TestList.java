import java.util.ArrayList;
import java.util.List;

public class TestList {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result =new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1) {
            return result;
        }
        ArrayList<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        for(int row = 3;row<=numRows;row++) {
            List<Integer> prevLine = result.get(row-1-1);
            ArrayList<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for(int col = 2;col<=row-1;col++) {
                int tmp1 = prevLine.get(col-1-1);
                int tmp2 = prevLine.get(col-1);
                curLine.add(tmp1+tmp2);

            }
            curLine.add(1);
        }
        return result;
    }
}
