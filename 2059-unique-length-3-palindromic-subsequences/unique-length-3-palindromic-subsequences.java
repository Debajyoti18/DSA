class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> st=new HashSet<>();
        int n=s.length(),count=0;
            for(int i=0;i<n;i++){
                st.add(s.charAt(i));
            }
            for(char ch : st){
               int first=-1;
               int sec=-1;
               for(int i=0;i<n;i++){
                    if(ch==s.charAt(i)){
                        if(first==-1){
                            first=i;
                        }
                        sec=i;
                    }
                }
                if(first == sec)continue;
                  HashSet<Character> st1=new HashSet<>();
            for(int i=first+1;i<sec;i++){
                    st1.add(s.charAt(i));
                  }
                  count += st1.size();
            }
            return count;
    }
}