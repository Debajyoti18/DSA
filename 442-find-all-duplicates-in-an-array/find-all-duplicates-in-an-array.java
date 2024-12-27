//brute-force TC=O(n^2) sc=O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int c=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    c++;
                }
            }
           if(c==2 && !li.contains(nums[i])){
            li.add(nums[i]);
           }
        }
        
        return li;
    }
}


//optimal Tc=O(n) sc=O(n)
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
