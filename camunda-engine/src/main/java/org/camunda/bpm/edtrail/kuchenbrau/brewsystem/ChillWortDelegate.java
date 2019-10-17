package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ChillWortDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating wort chilling phase");
        System.out.println("Cooling wort to 70 degrees");
        for (int i = 0; i < 5; i++) {
            System.out.println("Cooling...");
//            Thread.sleep(5000);
        }
        //set the wortTemp to 70
        delegateExecution.setVariable("wortTemp", 70);
        System.out.println("Cooling Complete");
    }
}
