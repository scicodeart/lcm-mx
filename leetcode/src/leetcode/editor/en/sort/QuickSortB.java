package leetcode.editor.en.sort;

public class QuickSortB {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 22, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {

        if (left > right) return;
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {

        int pivot = nums[left];
        while (left < right) {
            while ((left < right) && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while ((left < right) && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
