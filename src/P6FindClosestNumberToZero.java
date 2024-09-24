class P6FindClosestNumberToZero {

    public static void main(String[] args) {
        int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        int closest = findClosestNumberToZero(arr);
        System.out.println("Closest number to zero: " + closest);

        int[] arr2 = {-10000,-10000};
        int closest2 = findClosestNumberToZero(arr2);
        System.out.println("Closest number to zero2: " + closest2);

        int[] arr3 = {-4,-2,1,4,8};
        int closest3 = findClosestNumberToZero(arr3);
        System.out.println("Closest number to zero3: " + closest3);

    }

    private static int findClosestNumberToZero(int[] arr) {

        if (arr == null || arr.length == 0)
            return 0;

        // Initialize the closest number with a very large value
        int closest = Integer.MAX_VALUE;

        // Iterate through the array to find the closest number to zero
        for (int num : arr) {
            // Calculate the absolute value of the current number
            // absolute value is used to handle negative numbers
            // that mean we use Math.abs(num) to get positive value   -1 abs = 1 , 2 abs = 2 like this.
            int absValue = Math.abs(num);

            // Update the closest value if a smaller absolute value is found,
            // or if the absolute values are the same but the current number is positive.
            if (absValue < Math.abs(closest)) {
                closest = num;
            }else if(absValue == Math.abs(closest) && num > closest){
                closest = num;
            }

            // Or You can simply using || operator for extra condition
            // if (absValue < Math.abs(closest) || (absValue == Math.abs(closest) && num > closest)) {
            //     closest = num;
            // }
        }

        return closest;

    }
}