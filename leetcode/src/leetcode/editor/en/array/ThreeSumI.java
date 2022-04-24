package leetcode.editor.en.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hermione.lai
 * @date 2022/4/24 9:01 PM
 */
public class ThreeSumI {

  class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

      //排序
      Arrays.sort(nums);
      //定义结果集
      List<List<Integer>> result = new ArrayList<>();
      //一层循环
      for (int i = 0; i < nums.length - 2; i++) {
        //如果最小值>0，则说明无法得出结果
        if (nums[i] > 0) {
          break;
        }
        //如果重复，则继续往前推进，因为会重复计算
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        //定义双指针
        int k = i + 1, j = nums.length - 1;
        while (i < j) {
          int sum = nums[i] + nums[k] + nums[j];
          if (sum > 0) {
            j--;
          } else if (sum < 0) {
            i++;
          } else {
            // = 0 收集结果
            result.add(Arrays.asList(nums[i], nums[k], nums[j]));
            while (k < j && nums[k] == nums[k + 1]) {
              k++; // 使left指向最后一个重复元素
            }
            while (k < j && nums[j] == nums[j - 1]) {
              j--; // 使right指向最后一个重复元素
            }
            k++; // 下一轮
            j--; // 下一轮
          }
        }
      }
      return result;
    }
  }
}
