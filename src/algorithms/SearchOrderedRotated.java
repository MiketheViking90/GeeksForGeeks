package algorithms;

public class SearchOrderedRotated {

    public int findMin(int[] nums) {
        int len = nums.length;
        int index = findMin(0, len - 1, nums);
        return nums[index];
    }

    private int findMin(int lo, int hi, int[] nums) {
        if (lo > hi) {
            return -1;
        }

        int mid = (hi + lo) / 2;
        int midVal = nums[mid];
        int hiVal = nums[hi];

        if (nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }

        if (midVal > hiVal) {
            return findMin(mid + 1, hi, nums);
        } else {
            return findMin(lo, mid - 1, nums);
        }
    }


    public static void main(String[] args) {
        int[] nums = {5, 22, 123, 4242, 1, 2, 3, 4};

        SearchOrderedRotated search = new SearchOrderedRotated();
        int index = search.findMin(nums);
        System.out.println(index);
    }
}
