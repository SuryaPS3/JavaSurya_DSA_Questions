import java.util.Scanner;
//Easy implementation of kadane's algorithm to find the maximum subarrary sum
public class Leetcode_238_MaxSubArray {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + java.util.Arrays.toString(nums1));
        System.out.println("Maximum Subarray Sum: " + solution238.maxSubArray(nums1));

        System.out.println();

        int[] nums2 = {1};
        System.out.println("Input: " + java.util.Arrays.toString(nums2));
        System.out.println("Maximum Subarray Sum: " + solution238.maxSubArray(nums2));

        System.out.println();

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Input: " + java.util.Arrays.toString(nums3));
        System.out.println("Maximum Subarray Sum: " + solution238.maxSubArray(nums3));

        System.out.println();

        int[] nums4 = {-1, -2, -3, -4};
        System.out.println("Input: " + java.util.Arrays.toString(nums4));
        System.out.println("Maximum Subarray Sum: " + solution238.maxSubArray(nums4));
    }
}

class Solution238 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
