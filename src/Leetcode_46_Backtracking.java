import java.util.*;

public class Leetcode_46_Backtracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) nums[i]=sc.nextInt();
        sc.close();
        Solution46 s46 = new Solution46();
        System.out.println(s46.permute(nums));


    }
}
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean vis [] = new boolean[nums.length];
        backtrack(res,list,vis,nums);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> list, boolean[] vis,int[] nums){

        if(list.size() == nums.length ){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                list.add(nums[i]);
                vis[i]=true;
                backtrack(res,list,vis,nums);
                list.remove(list.size()-1);
                vis[i]=false;
            }

        }

    }
}