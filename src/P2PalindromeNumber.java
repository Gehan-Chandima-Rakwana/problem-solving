public class P2PalindromeNumber {
    public static void main(String[] args) {
        /*
            Given an integer x, return true if x is a palindrome, and false otherwise.

            Example 1:

            Input: x = 121
            Output: true
            Explanation: 121 reads as 121 from left to right and from right to left.

            Example 2:

            Input: x = -121
            Output: false
            Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

            Example 3:

            Input: x = 10
            Output: false
            Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

         */

        int x1 = 121;
        System.out.println("Scenario 1: " + isPalindrome(x1));

        int x2 = -121;
        System.out.println("Scenario 2: " + isPalindrome(x2));

        int x3 = 10;
        System.out.println("Scenario 3: " + isPalindrome(x3));
    }


    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }


        // initialize veriable to hold reverse number
        // get the last digit of given number
        //      (to do that use modulus operator (%):)
        //      (Integer is base 10(Desimal) so we use 10)
        //      bellow code if x = 121 it try to divide 121 by 10, it is 10 * 12 = 120 and remaining 1
        //      so 1 will the ansewer in modulus operator
        // int digit = x % 10;

        // then need to add this last digit to reverse number
        // to do that first we need to multiply by 10 and then add digit
        // in first time rn = 0, then 0 * 10 = 0, 0 + digit (1) = 1
        // in second loop rn =1, then 1 * 10 = 10, then 10 + digit (2) = 12

        // int rn = 0;
        // rn = rn * 10 + digit;

        // then need to remove last number (digit) from original value (x)
        // to do that need to devide that by 10
        // in first time x = 121, then 121 / 10 = 12, then asign that answer to x
        // in second time x = 12, then 12 / 10 = 1, then asign that answer to x

        // x = x / 10;

        // this process need to be in a loop until original value is  0

        int original = x;
        int rn = 0;
        while (x > 0){
            int digit = x % 10;
            rn = rn *10 + digit;
            x = x / 10;
        }

        return (original == rn);
    }
}
