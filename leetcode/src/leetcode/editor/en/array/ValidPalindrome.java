package leetcode.editor.en.array;

public class ValidPalindrome {

    //Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome.
//
// Example 1:
//
//
//Input: "A man, a plan, a canal: Panama"
//Output: true
//
//
// Example 2:
//
//
//Input: "race a car"
//Output: false
//
//
//
// Constraints:
//
//
// s consists only of printable ASCII characters.
//
// Related Topics Two Pointers String


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {

            //filter out number and char
            String filteredString = filterOutNumberAndChar(s);


            //reverse the string and compare
            String reversedString = reverseString(filteredString);


            //compare
            return reversedString.equalsIgnoreCase(filteredString);
        }

        private String reverseString(String filteredString) {
            return new StringBuilder(filteredString).reverse().toString();
        }

        private String filterOutNumberAndChar(String s) {
            StringBuffer sgood = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }

            return s.replaceAll("[^A-Za-z0-9]","");
        }

        /**
         * 优化 ：双指针法
         * @param s
         * @return
         */
        public boolean isPalindrome1(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
