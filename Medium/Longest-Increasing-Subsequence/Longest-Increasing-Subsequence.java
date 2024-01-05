interface Solution {
    static void main(String[]$) {
        var in = new java.util.Scanner(System.in);
        int nums[] = new int[in.nextInt()], len = 0;
        for (int i = 0; i < nums.length; i++) nums[i] = in.nextInt();
        for (int i = 0; i < nums.length; i++)
            if (len == 0 || nums[len - 1] < nums[i]) nums[len++] = nums[i];
            else nums[findIndex(nums, nums[i])] = nums[i];
        System.out.println(len);
    }
    static int findIndex(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) if (arr[i] >= n) return i;
        return -1;
    }
}
