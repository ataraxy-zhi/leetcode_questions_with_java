package com.solution.onequestionperday.nov2022;

public class CheckIfArrayIsSortedAndRotated1752 {

    public boolean check(int[] nums) {
        int n = nums.length, x = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                x = i;
                break;
            }
        }
        if (x == 0) {
            return true;
        }
        for (int i = x + 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return nums[0] >= nums[n - 1];
    }

}
