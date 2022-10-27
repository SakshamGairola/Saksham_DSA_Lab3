package greatLearning;

import greatLearning.Problem1.Solution1;
import greatLearning.Problem2.Solution2;

public class Main {
    public static void main(String[] args) {
        String test1 = "( [ [ { } ] ] )";
        String test2 = "( [ [ { } ] ] ) )";
        new Solution1(test1);
        new Solution1(test2);

        //first element is root
        int[] data = {40, 20, 30, 10, 60, 50, 70};
        int targetSum = 130;
        new Solution2(data, targetSum);


    }
}