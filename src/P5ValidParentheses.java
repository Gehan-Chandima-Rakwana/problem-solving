import java.util.HashMap;
import java.util.Map;

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

        String s = "()";
        boolean result1 = isValid(s);
        System.out.println(result1);

        s = "()[]{}";
        boolean result2 = isValid(s);
        System.out.println(result2);

        s = "(]";
        boolean result3 = isValid(s);
        System.out.println(result3);




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
