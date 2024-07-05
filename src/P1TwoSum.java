public class P1TwoSum {
    public static void main(String[] args) {
        /*
            Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
            You may assume that each input would have exactly one solution, and you may not use the same element twice.
            You can return the answer in any order.

            * Example 1:

            Input: nums = [2,7,11,15], target = 9
            Output: [0,1]
            Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

            * Example 2:

            Input: nums = [3,2,4], target = 6
            Output: [1,2]

            * Example 3:

            Input: nums = [3,3], target = 6
            Output: [0,1]
         */

        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Scenario 1: " + result1[0] + " " + result1[1]);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Scenario 2: " + result2[0] + " " + result2[1]);

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Scenario 3: " + result3[0] + " " + result3[1]);


    }


    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int x=i; x<nums.length; x++){
                if(i != x){
                    if((nums[i] + nums[x]) == target ){
                        return new int[] {i, x};
                    }
                }
            }
        }
        return new int[] {};
    }
}
