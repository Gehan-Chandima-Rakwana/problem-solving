import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P5ValidParentheses {

    public static void main(String[] args) {
    /**
        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
         An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.

        Example 1:
        Input: s = "()"
        Output: true

        Example 2:
        Input: s = "()[]{}"
        Output: true

        Example 3:
        Input: s = "(]"
        Output: false
    **/

        // Thease are valied for bellow scenarios
        // but the correct answer is using stack is below
        String s = "()";
        boolean result1 = isValid(s);
        System.out.println(result1);

        s = "()[]{}";
        boolean result2 = isValid(s);
        System.out.println(result2);

        s = "(]";
        boolean result3 = isValid(s);
        System.out.println(result3);


        // but the correct answer is using stack is below
        s = "()";
        boolean result4 = isValidWithStack(s);
        System.out.println("with stack: " + result4);

        s = "()[]{}";
        boolean result5 = isValidWithStack(s);
        System.out.println("with stack: " + result5);

        s = "(]";
        boolean result6 = isValidWithStack(s);
        System.out.println("with stack: " + result6);

        String expression1 = "({[]})";
        boolean result7 = isValidWithStack(expression1);
        System.out.println("with stack: " + result7);

        String expression2 = "({[}])";
        boolean result8 = isValidWithStack(expression2);
        System.out.println("with stack: " + result8);

    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }

    public static boolean isValidWithStack(String s) {
        //1.Use a stack of characters.
        //2.When you encounter an opening bracket, push it to the top of the stack.
        //3.When you encounter a closing bracket, check if the top of the stack was the opening for it.
        //If yes, pop it from the stack. Otherwise, return false.

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

        public static boolean isValid(String s) {
        // "()[]{}"
        // 1. need to split to an array
        // 2. in a loop
        // get first char = ( = arr[0]
        // get next char = ) = arr[0]+1;
        // need to store some where open and closing char
        // check every 2 by 2 in the loop

        if(s == null) return false;

        char[] arr = s.toCharArray();
        boolean result = true;

        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');

        for(int i=0; i<arr.length; i++){
            if(i%2 == 0){
                char c = arr[i];
                char mapR = charMap.get(c);
                if(mapR != arr[i + 1])
                    result = false;
            }
        }

        return result;
    }
}
