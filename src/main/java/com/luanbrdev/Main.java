package com.luanbrdev;

import jdk.crac.Core;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var warmUpBean = new WarmUp();
        var resource = new MyCRaCResource(warmUpBean);

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 500).forEach(i -> {
                executor.submit(() -> {
                    warmUpBean.somethingImportant.add("Important-" +i);
                    warmUpBean.somethingUnnecessary.add("Unnecessary-" +i);
                    return i;
                });
            });
        }
        Core.getGlobalContext().register(resource);
        System.out.println("Register resouce - " + Core.getGlobalContext().toString());

        for (int i = 1; i <= 1000; i++) {
            System.out.println("i = " + i);
            Thread.sleep(500);
        }
    }
}