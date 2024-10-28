public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int target = 2;
        int targetLocation = bs.search(nums, target);
        System.out.println("targetLocation = " + targetLocation);
    }
    public int search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}