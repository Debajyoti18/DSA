class Solution {
    public int maxScore(String s) {
        int sum=0,totalones=0,zeros=0;
        for (char c : s.toCharArray()){
           if(c=='1')
           totalones++;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                zeros++;
            }else{
                totalones--;
            }
            sum=Math.max(sum,totalones+zeros);
        }
        return sum;
    }
}