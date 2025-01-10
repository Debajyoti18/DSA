
Time Complxity = O(word2_length * each_word2.length*26 + word1.length*each_word1.length*26)
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq=new int[26];
        for(String str : words2){
            int[] temp = getFrequency(str);
            for(int i=0; i < 26; i++){
                freq[i] = Math.max(freq[i],temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(String str : words1){
            int[] temp = getFrequency(str);
            boolean flag = true;
            for(int i=0; i < 26; i++){
              if(freq[i] > temp[i]){
                flag = false;
                break;
              }
            }
            if(flag){
                res.add(str);
            }
        }
        return res;
    }
    public int[] getFrequency(String s){
         int[] freq=new int[26];
         for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
         }
         return freq;
    }

}
