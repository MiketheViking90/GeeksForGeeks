package algorithms;

public class InversionCount {

    public int count(int[] nums) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len-1; i++) {
            int n1 = nums[i];

            for (int j = i+1; j < len; j++) {
                int n2 = nums[j];

                if (n2 < n1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        InversionCount ic = new InversionCount();
        int[] nums = {5, 4, 3, 2, 1};
        int cnt = ic.count(nums);
        System.out.println(cnt);
    }
}
