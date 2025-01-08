class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer> firstOcc=new HashMap<>();
         HashMap<Character,Integer> lastOcc=new HashMap<>();
        int n=s.length(),count=0;
            for(int i=0;i<n;i++){
              char ch=s.charAt(i);
              if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch,i);
              }
              lastOcc.put(ch,i);
            }
            for(char ch : firstOcc.keySet()){
               int first=firstOcc.get(ch);
               int sec=lastOcc.get(ch);
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