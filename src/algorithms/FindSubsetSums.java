package algorithms;

public class FindSubsetSums {

    public void findSums(int[] nums) {
        findSumsR(nums, 0, 0);
    }

    private void findSumsR(int[] nums, int i, int sum) {
        if (i == nums.length) {
            System.out.println(sum);
            return;
        }

        findSumsR(nums, i+1, sum);
        findSumsR(nums, i+1, sum + nums[i]);
    }

    public static void main(String[] args) {
        FindSubsetSums fss = new FindSubsetSums();
        int[] nums = {3, 1, 4};
        fss.findSums(nums);
    }
}
