import java.util.*;
public class Leetcode_22_Backtracking {
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of parenthesis");
        System.out.println(s2.generateParenthesis(sc.nextInt()));
        sc.close();
    }
}
class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,new StringBuilder(),0,0,n);
        return res;
    }

    private void backtrack(List<String> res,StringBuilder sb, int open, int close, int siz){
        if(sb.length()==siz*2){
            res.add(new String(sb.toString()));
        }
        if(open<siz){
            sb.append("(");
            backtrack(res,sb,open+1,close,siz);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backtrack(res,sb,open,close+1,siz);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
