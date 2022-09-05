package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author chuanminlai
 * @since 2022/9/5 3:14 PM
 */
public class testCompletable {

    public static void main(String[] args) {
        // 创建异步执行任务:
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.forEach(a->{
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(()-> a);
            // 如果执行成功:
            cf.thenAccept((result) -> {
                System.out.println("price: " + result);
            });
            // 如果执行异常:
            cf.exceptionally((e) -> {
                e.printStackTrace();
                return null;
            });
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
//        Thread.sleep(200);
    }
}
