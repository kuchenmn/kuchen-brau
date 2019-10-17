package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class LageringDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating Lagering Phase");
        System.out.println("Cooling wort to 40 degrees");
        for (int i = 0; i < 5; i++) {
            System.out.println("Cooling...");
//            Thread.sleep(5000);
        }
        //set the yeast temp to 78
        delegateExecution.setVariable("wortTemperature", 40);
        System.out.println("Wort Lagering at Proper Temperature");
        System.out.println("Lagering Complete");
    }
}
