class Solution {
    public boolean canJump(int[] nums) {
        int jump=0, n=nums.length, i=0;
        if(n<=1)    return true;
        while(jump<=n && i<n-1){
            jump--;
            if(nums[i]==0 && jump<=0)   return false;
            if(nums[i]>jump) jump=nums[i];
            i++;
        }
        return true;
    }
}