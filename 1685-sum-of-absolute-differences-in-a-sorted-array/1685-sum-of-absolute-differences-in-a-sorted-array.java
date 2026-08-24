class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            long rightSum = totalSum - leftSum - nums[i];

            long left = (long) nums[i] * i - leftSum;
            long right = rightSum - (long) nums[i] * (n - i - 1);

            result[i] = (int) (left + right);

            leftSum += nums[i];
        }

        return result;
    }
}
