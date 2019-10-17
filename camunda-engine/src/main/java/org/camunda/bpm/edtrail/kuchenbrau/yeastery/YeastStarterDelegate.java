package org.camunda.bpm.edtrail.kuchenbrau.yeastery;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class YeastStarterDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating Yeast Starter");
        System.out.println("Mixingt Starter");
        System.out.println("Yeast Starter Complete");
    }
}
