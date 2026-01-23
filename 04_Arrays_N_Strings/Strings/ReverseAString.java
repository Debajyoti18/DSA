class Solution {
    public String reverseWords(String s) {
     String[] str = s.trim().split(" ");
     //Trim to remove leading and trailing spaces and  split make an array of words
      StringBuilder sb = new StringBuilder();
      for(int i = str.length-1 ; i >=0 ; i--){
        // only append non empty strings to avoid multiple spaces
        if(str[i].length() > 0){
        sb.append(str[i]);
        sb.append(" ");
        }
      }
      // Remove the trailing space and return the result
      return sb.substring(0,sb.length()-1).toString();
    }
}