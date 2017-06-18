package algorithms;

public class KeyPair {

    /**
     * Given an array A[] of n numbers and another number x,
     * determine whether or not there exist two elements in A whose sum is exactly x.
     */
    boolean sumToX(int[] nums, int x) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int s1 = nums[i];

            for (int j=i+1; j<n; j++) {
                int s2 = nums[j];

                if (s1+s2 == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
