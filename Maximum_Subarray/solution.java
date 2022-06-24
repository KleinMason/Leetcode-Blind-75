package Maximum_Subarray;

/**
 * NOTE: Reset currentMax to i if currentMax is ever < 0.
 * Set maxSoFar to the greater value between maxSoFar and currentSum.
 */

public class solution {
    public static int maxSubArray(int[] nums) {
        int currentMax = 0, maxSoFar = Integer.MIN_VALUE;
        for (int i : nums) {
            currentMax = Math.max(i, currentMax + i);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int out = maxSubArray(nums);
        System.out.println(out);
    }
}
