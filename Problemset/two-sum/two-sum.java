
// @Title: 两数之和 (Two Sum)
// @Author: luffyyy@vip.qq.com
// @Date: 2021-03-29 14:46:58
// @Runtime: 0 ms
// @Memory: 38.4 MB

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0 ; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}

