package greatLearning;

import greatLearning.Problem1.Solution1;

public class Main {
    public static void main(String[] args) {
        String test1 = "( [ [ { } ] ] )";
        String test2 = "( [ [ { } ] ] ) )";
        new Solution1(test1);
        System.out.println();
        new Solution1(test2);


    }
}