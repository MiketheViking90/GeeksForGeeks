package algorithms;

public class FloorInSortedArray {

    public int findFloor(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;

        int loVal = nums[lo];
        int hiVal = nums[hi];
        if (k < loVal) {
            return -1;
        }
        if (k > hiVal) {
            return nums.length-1;
        }

        System.out.println(k + ", " + loVal);
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int midVal = nums[mid];

            if (midVal < k && nums[mid+1] >= k) {
                return mid;
            } else if (midVal > k){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 11, 12, 19};
        int k = 0;

        FloorInSortedArray f = new FloorInSortedArray();
        int i = f.findFloor(nums, k);
        System.out.println(i + ": " + nums[i]);
    }
}
