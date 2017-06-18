package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public boolean subsetSum(int[] nums, int sum) {
        return subsetSum(0, 0, "", nums, sum);
    }

    private boolean subsetSum(int curSum, int i, String index, int[] nums, int sum) {
        if (curSum == sum) {
            System.out.println(index);
            return true;
        }

        if (i == nums.length) {
            return false;
        }

        int curNum = nums[i];
        boolean inSum = subsetSum(curSum + curNum, i+1, index+"1", nums, sum);
        boolean notInSum = subsetSum(curSum, i+1, index+"0", nums, sum);

        return inSum || notInSum;
    }

    public int subsetSumDp(int[] nums, int sum) {
        int len = nums.length;
        int[][] M = new int[len + 1][sum + 1];

        for (int num = 1; num <= len; num++) {
            int curVal = nums[num - 1];
            for (int curSum = 1; curSum <= sum; curSum++) {
                if (curVal > curSum) {
                    M[num][curSum] = M[num-1][curSum];
                } else {
                    int include = M[num-1][curSum - curVal] + curVal;
                    int notInclude = M[num-1][curSum];

                    M[num][curSum] = Math.max(include, notInclude);
                }
            }
        }

        return M[len][sum];
    }

    public List<List<Integer>> getSubsetSums(int nums[], int sum) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        getSubsetSums(subsets, new ArrayList<Integer>(), nums, sum, 0);
        return subsets;
    }

    private void getSubsetSums(List<List<Integer>> subsets, ArrayList<Integer> curSubset, int[] nums, int sum, int index) {
        if (sum == 0) {
            subsets.add(new ArrayList<>(curSubset));
        } else if (sum > 0) {
            for (int i = index + 1; i < nums.length && sum >= nums[i]; i++) {
                curSubset.add(nums[i]);
                getSubsetSums(subsets, curSubset, nums, sum - nums[i], i);
                curSubset.remove(curSubset.size() - 1);
            }
        }
    }

    public int knapsackSum(int[] weights, int[] values, int capacity) {
        int count = weights.length;
        int[][] M = new int[count + 1][capacity + 1];

        for (int i = 1; i <= count; i++) {
            int val = values[i-1];
            int weight = weights[i-1];
            for (int j = 0; j <= capacity; j++) {
                if (weight > j) {
                    M[i][j] = M[i-1][j];
                } else {
                    int include = M[i-1][j-weight] + val;
                    int uninclude = M[i-1][j];

                    M[i][j] = Math.max(include, uninclude);
                }
            }
        }

        return M[count][capacity];
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 7};
        SubsetSum ss = new SubsetSum();
        int subsets = ss.subsetSumDp(nums, 7);
        System.out.println(subsets);

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int  W = 50;
        System.out.println(ss.knapsackSum(wt, val, W));
    }

}
