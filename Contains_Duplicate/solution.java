package Contains_Duplicate;

import java.util.HashSet;

public class solution {
    public boolean containsDuplicate(int[] nums) {
        /**
         * First solution: Accepted
         */
        HashSet<Integer> list = new HashSet<>();

        for (int i : nums) {
            if (list.contains(i)) return true;
            list.add(i);
        }

        return false;
    }
}
