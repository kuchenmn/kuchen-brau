package org.camunda.bpm.edtrail.kuchenbrau.yeastery;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProofYeastDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating Yeast Proofing");
        System.out.println("Warming yeast to 83 degrees");
        for (int i = 0; i < 5; i++) {
            System.out.println("Warming...");
//            Thread.sleep(5000);
        }
        //set the yeast temp to 83
        delegateExecution.setVariable("yeastTemperature", 83);
        System.out.println("Waiting for full activation");
//        Thread.sleep(30000);
        System.out.println("Yeast Fully Proofed");
    }
}
