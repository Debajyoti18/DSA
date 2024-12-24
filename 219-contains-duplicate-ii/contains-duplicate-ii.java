class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0 ; i < nums.length ; i++){
            //if already in map check simultaneously
           if(mp.containsKey(nums[i])){
            int preindex=mp.get(nums[i]);
                if(i-preindex <= k){
                 return true;
                 }
           }
           //if not in map put in the map
           mp.put(nums[i],i);
        } 
       
            return false;
     

    }
}