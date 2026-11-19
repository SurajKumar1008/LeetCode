class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];

        for(int i=1; i < nums.length; i++){
            int num = nums[i];

            if(num<0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(num,maxProduct*num);
            minProduct = Math.min(num, minProduct*num);

            ans = Math.max(ans,maxProduct);
        }
        return ans;
    }
}