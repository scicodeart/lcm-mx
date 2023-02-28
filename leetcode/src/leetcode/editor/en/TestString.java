package leetcode.editor.en;

import static java.math.BigInteger.ZERO;

/**
 * @author chuanminlai
 * @since 2022/10/20 8:49 PM
 */
public class TestString {

    public static void main(String[] args) {

        String VIP_LANDING_PAGE_PATH = "/pages/landing_page/%s/index?id=%s&preview=%s";

        String test = "/pages/landing_page/%s/index?id=";
        System.out.println(String.format(test,"tenant"));

        String vipLinkUrl = String.format(VIP_LANDING_PAGE_PATH, "raven", 888, ZERO);


//        URLEncodedUtils.
        System.out.println(vipLinkUrl);
    }
}
