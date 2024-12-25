class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str=s.split(" ");
        if(pattern.length()!=str.length)
        return false;

        //creating A map
        Map<Character,String>  map=new HashMap<>();

        for(int i=0;i< pattern.length(); i++){
            char c = pattern.charAt(i);
            String test=str[i];
            //if character already in map
            if(map.containsKey(c)){
                //then it should match with its value if not then false
                if(!map.get(c).equals(test)){
                    return false;
                }
            }else{

                if(map.containsValue(test))
                return false;
                map.put(c,test);
            }
        }
        // if all goes well and all char of pattern is mapped to unique 
        // then return true
    return true;
    }
}