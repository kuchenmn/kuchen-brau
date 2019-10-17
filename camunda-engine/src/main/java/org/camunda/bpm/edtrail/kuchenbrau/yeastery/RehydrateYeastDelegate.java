package org.camunda.bpm.edtrail.kuchenbrau.yeastery;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RehydrateYeastDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Rehydrating yeast");
        System.out.println("Yeast Rehydration Complete");
    }
}
