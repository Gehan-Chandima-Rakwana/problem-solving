public class P4LongestCommonPrefix {

    public static void main(String[] args) {
/**
//        Write a function to find the longest common prefix string amongst an array of strings.
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//
//        Example 2:
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
**/

        String[] strs = {"flower","flow","flight"};
        String result = longestCommonPrefix(strs);
        System.out.println("Scenario 1: " + result);

        strs = new String[] {"dog","racecar","car"};
        result = longestCommonPrefix(strs);
        System.out.println("Scenario 2: " + result);

    }

    private static String longestCommonPrefix(String[] strs) {
        /**
         * 1. String arr if null or empty return empty string
         * 2. If only one string in the array return that string
         * 3. Need to find shortest string in the array
         * 4. assign the shortest string length to a variable
         *       Arrays.sort(strs);
         *       String shortestString = strs[0];
         *       int shortestStringLength = shortestString.length();
         *     Instead using below code we can use above code.
         *     (below code what done is we assign integer max value to a variable (it is MAX_VALUE = 2147483647)
         *     Then loop the string array and check if the string length is less than MAX_VALUE then it is the shortest string length)
         *
         *     why we find it : because we want to compare each character with other strings in the array
         *
         *     then we need to loop n times n = shortestStringLength
         *     inside first we assign array first index first character to a variable (t)
         *     then loop through the string array and check the same character is equal to t or not
         *      1. t = f
         *      2. t = arr[0].charAt(i) = f
         *      2. t = arr[1].charAt(i) = f
         *      2. t = arr[2].charAt(i) = f
         *      3. t = l
         *      3. t = arr[0].charAt(i) = l
         *      3. t = arr[1].charAt(i) = l
         *      3. t = arr[2].charAt(i) = l
         */
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int arrL = strs.length;
        StringBuilder prefix = new StringBuilder();
        int n = Integer.MAX_VALUE;

        for (String w : strs) {
            if (n > w.length()) {
                n = w.length(); // Find the length of the shortest string
            }
        }

        for (int i = 0; i < n; i++) {
            char t = strs[0].charAt(i); // Initialize t with the first character of the first string
            boolean allMatch = true;

            for (int x = 1; x < arrL; x++) {
                if (strs[x].charAt(i) != t) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                prefix.append(t);
            } else {
                break;
            }
        }

        return prefix.toString();
    }



/**
    1. Vertical Scanning
    This method involves comparing characters column by column (i.e., character by character for each position).

    2. Horizontal Scanning
    This method involves comparing the prefix of the first string with each subsequent string and updating the prefix.

    3. Divide and Conquer
    This method splits the array of strings into two halves, finds the longest common prefix in each half, and then combines the results.

    4. Binary Search
    This method involves binary searching on the length of the prefix to find the longest common prefix.
 **/


    ////////////////////////////////////////////////////////////////////////////////////
//    1. Vertical Scanning
    private static String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }


    ////////////////////////////////////////////////////////////////////////////////////
//    2. Horizontal Scanning
    private static String longestCommonPrefixHorizontal(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }


    ////////////////////////////////////////////////////////////////////////////////////
//    4. Binary Search

    private static String longestCommonPrefixBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////


}
