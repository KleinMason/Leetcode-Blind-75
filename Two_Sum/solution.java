package Two_Sum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * First solution
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
            map.put(nums[i], i);
        }

        return new int[]{0,0};
    }
}