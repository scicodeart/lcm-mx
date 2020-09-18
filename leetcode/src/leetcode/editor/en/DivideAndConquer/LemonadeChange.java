package leetcode.editor.en.DivideAndConquer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-18 00:50
 */
public class LemonadeChange {
    //At a lemonade stand, each lemonade costs $5.
//
// Customers are standing in a queue to buy from you, and order one at a time (i
//n the order specified by bills).
//
// Each customer will only buy one lemonade and pay with either a $5, $10, or $2
//0 bill. You must provide the correct change to each customer, so that the net tr
//ansaction is that the customer pays $5.
//
// Note that you don't have any change in hand at first.
//
// Return true if and only if you can provide every customer with correct change
//.
//
//
//
//
// Example 1:
//
//
//Input: [5,5,5,10,20]
//Output: true
//Explanation:
//From the first 3 customers, we collect three $5 bills in order.
//From the fourth customer, we collect a $10 bill and give back a $5.
//From the fifth customer, we give a $10 bill and a $5 bill.
//Since all customers got correct change, we output true.
//
//
//
// Example 2:
//
//
//Input: [5,5,10]
//Output: true
//
//
//
// Example 3:
//
//
//Input: [10,10]
//Output: false
//
//
//
// Example 4:
//
//
//Input: [5,5,10,10,20]
//Output: false
//Explanation:
//From the first two customers in order, we collect two $5 bills.
//For the next two customers in order, we collect a $10 bill and give back a $5
//bill.
//For the last customer, we can't give change of $15 back because we only have t
//wo $10 bills.
//Since not every customer received correct change, the answer is false.
//
//
//
//
// Note:
//
//
// 0 <= bills.length <= 10000
// bills[i] will be either 5, 10, or 20.
//
//
//
//
//
// Related Topics Greedy


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int count = 0;
            int count10 = 0;

            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    count++;
                }
                if (bills[i] == 10) {
                    count--;
                    count10++;
                    if (count < 0) return false;
                }
                if (bills[i] == 20) {
                    if (count10 > 0) {
                        count10--;
                        count--;
                    } else {
                        count = count - 3;
                    }
                    if (count < 0) return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
