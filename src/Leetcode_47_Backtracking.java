import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.*;

public class Leetcode_47_Backtracking {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("You can give the input like \"1 2 3\" or \"[1,2,3]\"");
        String line = sc.nextLine().trim();


        // remove square brackets if present
        line = line.replaceAll("[\\[\\]]", "").trim();

        // detect separator: space or comma
        String[] parts;
        if (line.contains(",")) {
            parts = line.split("\\s*,\\s*");   // split by commas
        } else {
            parts = line.split("\\s+");        // split by spaces
        }

        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution47 sol = new Solution47();
        List<List<Integer>> res = sol.permuteUnique(nums);

        // convert each list into a concatenated string (like "123")
        List<String> stringRes = new ArrayList<>();
        for (List<Integer> perm : res) {
            StringBuilder sb = new StringBuilder();
            for (int n : perm) sb.append(n);
            stringRes.add(sb.toString());
        }

        System.out.println(stringRes);
    }
}


class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean vis[]= new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set,res,list,vis,nums);
        return res;
    }
    private void backtrack(Set<List<Integer>> set, List<List<Integer>> res, List<Integer> list, boolean[] vis, int[] nums){
        if(list.size()==nums.length){
            if(!set.contains(list)){
                set.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(!vis[i]){
                list.add(nums[i]);
                vis[i]=true;
                backtrack(set,res,list,vis,nums);
                list.remove(list.size()-1);
                vis[i]=false;
            }
        }
    }
}