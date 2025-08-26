import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Leetcode_503_MonotonicStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);
        Solution503 solution503 = new  Solution503();
        System.out.println(Arrays.toString(solution503.nextGreaterElements(arr)));
    }
}
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> s = new Stack<>();
        int res[] = new int[n];
        Arrays.fill(res,-1);
        for(int i =0;i<n*2;i++){
            int i_range=i%n;
            while(!s.isEmpty() && nums[i_range]>nums[s.peek()]){
                int index = s.pop();
                res[index]=nums[i_range];
            }
            if(res[i_range]==-1){s.push(i_range);}
        }
        return res;
    }
}
//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
//
//
//
//Example 1:
//
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2;
//The number 2 can't find next greater number.
//The second 1's next greater number needs to search circularly, which is also 2.
//Example 2:
//
//Input: nums = [1,2,3,4,3]
//Output: [2,3,4,-1,4]