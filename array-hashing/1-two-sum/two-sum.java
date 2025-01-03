class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int n=map.get(nums[i]);
                res[0]=n;
                res[1]=i;          
                  }else {
                    map.put(target-nums[i],i);
                  }
        }
        return res;
    }
}