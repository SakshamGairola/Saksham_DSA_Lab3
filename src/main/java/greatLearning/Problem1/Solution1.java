package greatLearning.Problem1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {

    public Solution1(String agr) {
        if(CheckBrackets(agr)){
            System.out.println("The entered String has Balanced Brackets");
        }else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }

    private boolean CheckBrackets(String agr) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < agr.length(); i++) {
            char ch = agr.charAt(i);
            if(ch==' '){
                continue;
            }
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if(stack.isEmpty()){
                return false;
            }
            char check;
            switch (ch) {
                case ')' -> {
                    check = stack.pop();
                    if(check == '{' || check == '['){
                        return false;
                    }
                }
                case '}' -> {
                    check = stack.pop();
                    if(check == '(' || check == '['){
                        return false;
                    }
                }
                case ']' -> {
                    check = stack.pop();
                    if(check == '{' || check == '('){
                        return false;
                    }
                }
            }

        }
        return (stack.isEmpty());
    }
}
