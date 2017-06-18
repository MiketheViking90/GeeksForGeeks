package algorithms;

public class LengthUnsortedSubarray {

    public int unsortedLength(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while ((i < j-1)
                && (nums[i] <= nums[i+1])) {
            i++;
        }

        while ((j > i)
                && (nums[j] >= nums[j-1])) {
            j--;
        }

        return j-i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 5, 7, 2, 8, 9};

        LengthUnsortedSubarray lu = new LengthUnsortedSubarray();
        int len = lu.unsortedLength(nums);
        System.out.println(len);
    }
}
