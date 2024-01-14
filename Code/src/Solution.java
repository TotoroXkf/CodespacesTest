class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i];
        }
        int right = 1;
        for (int i = result.length - 1; i > 0; i--) {
            result[i] = result[i - 1] * right;
            right *= nums[i];
        }
        result[0] = right;
        return result;
    }
}