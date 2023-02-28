package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author chuanminlai
 * @since 2022/9/5 3:14 PM
 */
public class testCompletable {

    public static void main(String[] args) {
        // 创建异步执行任务:
        /*********** 异步添加 **************/
        List<Integer> list = new ArrayList<>();
        CompletableFuture[] comArrays = new CompletableFuture[1000];
        for (int i = 0; i < 1000; i++) {
            //返回微盛门店ID
            int finalI = i;
            CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
                System.out.println(finalI);
                if (finalI == 50){
                    throw new RuntimeException("aaaa");
                }
                return finalI;
            });
            //执行成功，则添加
            cf.thenAccept(list::add);
            // 如果执行异常:
            cf.exceptionally((e) -> null);
            comArrays[i] = cf;
        }
        try {
            CompletableFuture.allOf(comArrays).get(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("********************************");
        System.out.println(list);
//        System.out.println("阻塞之后：" + Arrays.toString(wsShopsAddList.toArray()));
    }
}
