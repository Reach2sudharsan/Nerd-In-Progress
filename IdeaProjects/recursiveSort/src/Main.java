import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(recursiveSort(new int[]{5,6,2,9,3}, 0)));
    }

    // RecursiveSort is essentially SelectionSort, only that recursion is used.
    public static int[] recursiveSort(int[] nums, int count) {
        int min = count;
        for (int i = count; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
        }

        int temp = nums[count];
        nums[count] = nums[min];
        nums[min] = temp;

        if (count < nums.length-1) {
            return recursiveSort(nums, count+1);
        }
        else {
            return nums;
        }
    }
}
