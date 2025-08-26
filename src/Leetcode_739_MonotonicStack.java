import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Leetcode_739_MonotonicStack {

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        System.out.println(Arrays.toString(solution739.dailyTemperatures(arr)));
    }
}
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();//monotonic stack:usually stores indexes
        for(int i =0;i<n;i++){
            while(!s.isEmpty()&&temperatures[i]>temperatures[s.peek()]){
                int index = s.pop();
                res[index]=i-index;
            }
            s.push(i);
        }
        return res;
    }
}
//    Example 1:
//
//    Input: temperatures = [73,74,75,71,69,72,76,73]
//    Output: [1,1,4,2,1,1,0,0]
//    Example 2:
//
//    Input: temperatures = [30,40,50,60]
//    Output: [1,1,1,0]
//    Example 3:
//
//    Input: temperatures = [30,60,90]
//    Output: [1,1,0]