import java.util.*;

class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,2,3,4};
        System.out.println("nums1 result = " + cd.hasDuplicate(nums1));
        System.out.println("nums2 result = " + cd.hasDuplicate(nums2));
    }
    public boolean hasDuplicate(int[] nums) {
        HashMap<String, String> hm = new HashMap<String, String>();
        for(int i = 0; i < nums.length; i++) {
            if(hm.get("" + nums[i]) == null) {
                hm.put("" + nums[i], "" + nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}