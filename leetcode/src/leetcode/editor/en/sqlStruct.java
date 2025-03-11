package leetcode.editor.en;


/**
 * @author chuanminlai
 * @since 2023/3/6 3:10 PM
 */
public class sqlStruct {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 32; y++) {
                String sql = "alter table cashier_oms_%s.s_cashier_order_%s add cancel_time timestamp null comment '取消时间' after upload_time;";
                String format = String.format(sql, y, i);
                System.out.printf(format);
            }
        }

    }
}
