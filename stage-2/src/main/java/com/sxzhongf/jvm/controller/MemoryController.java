package com.sxzhongf.jvm.controller;

import com.sxzhongf.jvm.Metaspace;
import com.sxzhongf.jvm.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * MemoryController for : TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/6/22
 */
@RequestMapping(path = "/jvm")
@RestController
public class MemoryController {
    private List<UserVO> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<>();

    /**
     * 堆异常溢出
     *
     * -Xmx32M -Xms32M
     * Exception: java.lang.OutOfMemoryError thrown
     * from the UncaughtExceptionHandler
     * in thread "http-nio-8080-ClientPoller"
     *
     * @return
     */
    @GetMapping("/heap")
    public String heap() {
        int i = 0;
        while (true) {
            UserVO a = new UserVO(i++, UUID.randomUUID().toString());
            userList.add(a);
        }
    }

    /**
     * 非堆内存溢出演示
     * -XX:MaxMetaspaceSize=32M -XX:MetaspaceSize=32M
     *
     * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     * @return
     */
    @GetMapping("/nonheap")
    public String nonheap() {
        int i = 0;
        while (true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}
