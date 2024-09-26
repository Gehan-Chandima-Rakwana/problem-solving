public class P7ReverseStringTwoPointers {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        System.out.println(arr);
    }

    // Time: O(N) | Space: O(1)
    // where N is the length of the array
    // Explanation: about two pointers, why we use two poiters
    // because we can swap the values of two pointers
    // and move them towards each other
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}