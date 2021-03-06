package problem_6XX;
// 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

import java.util.Arrays;

public class _628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int mul1 = nums[n] * nums[n - 1] * nums[n - 2];
        int mul2 = nums[n] * nums[0] * nums[1];
        return Math.max(mul1, mul2);
    }

    public int maximumProduct_2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
