import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Leetcode_17_Backtracking {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the digits without any space");
        System.out.println(s.letterCombinations(sc.next()));
    }

}
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res,sb,map,digits,0);
        return res;
    }
    private void backtrack(List<String> res, StringBuilder sb, Map<Integer,String> map, String digits,int i){
        if(sb.length()==digits.length()){
            res.add(new String(sb.toString()));
            return;
        }
        String a = map.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
        for(char c : a.toCharArray()){
            sb.append(c);
            backtrack(res,sb,map,digits,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}