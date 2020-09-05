package leetcode.editor.en.array;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    //Write a program that outputs the string representation of numbers from 1 to n.
//
//
// But for multiples of three it should output “Fizz” instead of the number and
//for the multiples of five output “Buzz”. For numbers which are multiples of both
// three and five output “FizzBuzz”.
//
// Example:
//
//n = 15,
//
//Return:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
//
//


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<String>();

            for (int i = 1; i <= n; i++) {

                boolean divisibleBy3 = (i % 3 == 0);
                boolean divisibleBy5 = (i % 5 == 0);


                if (divisibleBy3 && divisibleBy5){
                    ans.add("FizzBuzz");
                } else if (divisibleBy3){
                    ans.add("Fizz");
                }else if (divisibleBy5){
                    ans.add("Buzz");
                }else {
                    ans.add(Integer.toString(i));
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
