package com.solution.onequestionperday.nov2022;

public class MinimumChangesToMakeAlternatingBinaryString1758 {

    /**
     * 先从结果入手，再正向推导
     */
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
