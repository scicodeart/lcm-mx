package com.example.utils;

import java.util.Optional;

/**
 * @author chuanminlai
 * @since 2023/3/8 4:45 PM
 */
public class OptionalUtils {

    public static void main(String[] args) {
        //of()：为非null的值创建一个Optional
        Optional<String> optional = Optional.of("bam");
        // isPresent()： 如果值存在返回true，否则返回false
        optional.isPresent();           // true
        //get()：如果Optional有值则将其返回，否则抛出NoSuchElementException
        optional.get();                 // "bam"
        //orElse()：如果有值则将其返回，否则返回指定的其它值
        optional.orElse("fallback");    // "bam"
        //ifPresent()：如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
