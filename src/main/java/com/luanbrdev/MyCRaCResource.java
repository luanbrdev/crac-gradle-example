package com.luanbrdev;

import jdk.crac.Context;
import jdk.crac.Resource;

public class MyCRaCResource implements Resource {

    private WarmUp warmUp;
    public MyCRaCResource(WarmUp warmUp) {
        this.warmUp = warmUp;
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("BeforeCheckpoint important size - " + warmUp.somethingImportant.size());
        System.out.println("BeforeCheckpoint unnecessary size - " + warmUp.somethingUnnecessary.size());

        System.out.println("BeforeCheckpoint Clear unnecessary");
        warmUp.somethingUnnecessary.clear();

        System.out.println("BeforeCheckpoint after clear important size - " + warmUp.somethingImportant.size());
        System.out.println("BeforeCheckpoint after clear unnecessary size - " + warmUp.somethingUnnecessary.size());
        System.out.println("Finish beforeCheckpoint");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        System.out.println("AfterRestore important size - " + warmUp.somethingImportant.size());
        System.out.println("AfterRestore unnecessary size - " + warmUp.somethingUnnecessary.size());
    }
}
