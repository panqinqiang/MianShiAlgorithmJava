package _20230925;

import java.util.Stack;

//左右括号匹配问题
public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        String openBrackets = "({[";
        String closeBrackets = ")}]";

        for(char c : s.toCharArray()){
            if(openBrackets.indexOf(c) != -1){
                stack.push(c);
            }else if(closeBrackets.indexOf(c) != -1){
                if(stack.isEmpty() || stack.pop() != getMatchingOpenBracket(c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static char getMatchingOpenBracket(char closeBracket){
        switch (closeBracket){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
}
