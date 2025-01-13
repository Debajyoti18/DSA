class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int c =0;
      for(int i=0;i<26;i++){
        if(freq[i]> 0){
            if(freq[i]%2==0){
                c += 2;
            }else{
                c +=1;
            }
        }
      }
      return c;
    }
}