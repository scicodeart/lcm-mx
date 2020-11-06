package leetcode.editor.en.sort;

public class QuickSortB {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
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

        int pivot = nums[0];
        while (left < right) {
            while ((left < right) && nums[left] <= pivot) {
                left++;
            }
            while ((left < right) && nums[right] >= pivot) {
                right--;
            }
            //交换
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            // TODO NEED FIX
        }

        return left;
    }
}
