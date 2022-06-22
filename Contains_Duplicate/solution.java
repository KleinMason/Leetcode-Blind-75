package Contains_Duplicate;

import java.util.HashSet;

/**
 * NOTE: Use a Set to track ever number seen in 
 * the `nums` array. A Set allows for easy checking
 * of duplicates.
 */

public class solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> list = new HashSet<>();

        for (int i : nums) {
            if (list.contains(i)) return true;
            list.add(i);
        }

        return false;
    }
}
