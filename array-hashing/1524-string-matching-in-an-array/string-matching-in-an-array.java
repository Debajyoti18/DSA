class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> li=new ArrayList<>();
        for( int i = 0; i < words.length ;i++){
            for(int j=0;j<words.length;j++){
                if(i==j)
                continue;
                if(words[j].contains(words[i])){
                    li.add(words[i]);
                    break;
                }
            }
        }
        return li;
    }
}
TIME COMPLEXITY-O(N^2)*string1length*string2length
