class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(m.get(target-nums[i])!=null && i!=m.get(target-nums[i]))
            {
                int[] data={i,m.get(target-nums[i])};
                        return data;
            }
        }
        return null;
    }
}