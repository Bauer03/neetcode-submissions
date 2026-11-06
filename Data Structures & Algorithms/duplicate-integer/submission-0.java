class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < (nums.length -1); i++) { // sorting solves this. Just arrays.sort and then if any number occurs more than once, return false
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}