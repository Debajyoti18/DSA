class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> li=new ArrayList<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : map.keySet()){
            if(map.get(num)==2){
                li.add(num);
            }
        }
        if(nums.length==0){
            return new ArrayList<>();
        }
        return li;
    }
}