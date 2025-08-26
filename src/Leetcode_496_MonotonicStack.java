import java.util.*;

public class Leetcode_496_MonotonicStack {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main array");
        String str1 = sc.nextLine();
        System.out.println("Enter the second array");
        String str2 = sc.nextLine();
        String [] s1 = str1.split(" ");
        String [] s2 = str2.split(" ");
        int[] arr =  new int[s1.length];
        int[] arr2 = new int[s2.length];

        for(int i=0;i<s1.length;i++){
            arr[i]=Integer.parseInt(s1[i]);
        }
        for(int i=0;i<s2.length;i++){
            arr2[i]=Integer.parseInt(s2[i]);
        }
        Solution496 solution496 = new Solution496();
        System.out.println(Arrays.toString(solution496.nextGreaterElement(arr2,arr)));
    }
}
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2= nums2.length;
        Map<Integer,Integer> valIndex = new HashMap<>();
        int n1 = nums1.length;
        int[] res1 = new int[n1];
        Stack<Integer> s = new Stack<>();

        for(int i =0;i<n2;i++){
            while(!s.isEmpty() && nums2[i]>nums2[s.peek()]){
                int index=s.pop();
                valIndex.put(nums2[index],nums2[i]);
            }
            s.push(i);
        }

        for(int i=0;i<n1;i++){
            if(!valIndex.containsKey(nums1[i])){
                res1[i]=-1;
            }else{
                res1[i]=valIndex.get(nums1[i]);
            }
        }
        return res1;
    }
}
//Input: nums1 = [2,4], nums2 = [1,2,3,4]
//Output: [3,-1]
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]