class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s,0,new ArrayList<>(), ans );
        return ans;
    }
    void solve(String s,int start, List<String> path,List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end<s.length(); end++){
            String part = s.substring(start,end+1);
            if (isPalindrome(part)){
                path.add(part);
                solve(s, end+1, path, ans);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left<right)
            if(s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    
    }
}