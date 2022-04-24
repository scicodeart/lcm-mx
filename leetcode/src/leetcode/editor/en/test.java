package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-18 20:39
 */
public class test {

    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> {
            System.out.println("只是执行一个方法，没有入参，也没有返回结果");
        });

        CompletableFuture.supplyAsync(() -> {
            System.out.println("没有入参，有返回结果");
            return 1;
        });

        //可以自定义线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture.runAsync(() -> {
            System.out.println("只是执行一个方法，没有入参，也没有返回结果, 可以使用自定义线程池");
        },executor);
    }
}
