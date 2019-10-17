package org.camunda.bpm.edtrail.kuchenbrau.yeastery;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TemperYeastDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating Yeast Tempering");
        System.out.println("Warming yeast to 78 degrees");
        for (int i = 0; i < 5; i++) {
            System.out.println("Warming...");
//            Thread.sleep(5000);
        }
        //set the yeast temp to 78
        delegateExecution.setVariable("yeastTemperature", 78);
        System.out.println("Yeast At Proper Temperature");
    }
}
