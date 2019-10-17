package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ResidualCO2Delegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating Release of CO2");
        System.out.println("Warming wort to 68 degrees");
        for (int i = 0; i < 3; i++) {
            System.out.println("Warming...");
//            Thread.sleep(5000);
        }
        //set the yeast temp to 78
        delegateExecution.setVariable("wortTemperature", 68);
        System.out.println("Residual CO2 Released");
    }
}
