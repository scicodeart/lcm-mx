package leetcode.editor.en;

import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chuanminlai
 * @since 2022/9/5 3:14 PM
 */
public class testCompletable {

    public static void main(String[] args) {
        // 创建异步执行任务:
        List<WsShop> wsShopsAddList = new ArrayList<>();
        /*********** 异步添加 **************/
        List<CompletableFuture<WsShop>> cfs = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            //返回微盛门店ID
            int finalI = i;
            CompletableFuture<WsShop> cf = CompletableFuture.supplyAsync(() -> {
                if (finalI != 0) {
                    return new WsShop(null,finalI,null,null,null,null,null,null,null,null,null,null,null);
                } else {
                    return null;
                }
            });


            //执行成功，则添加
            cf.thenAccept(wsShopsAddList::add);
            // 如果执行异常:
            cf.exceptionally((e) -> null);
            cfs.add(cf);
        }

//        System.out.println("阻塞之前：" + resTotal);
        CompletableFuture.allOf(cfs.toArray(new CompletableFuture[0])).join();
        System.out.println("********************************");
        System.out.println("阻塞之后：" + Arrays.toString(wsShopsAddList.toArray()));
    }
}
