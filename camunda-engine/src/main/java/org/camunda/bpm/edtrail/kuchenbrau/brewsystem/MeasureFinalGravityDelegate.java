package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MeasureFinalGravityDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Measuring Final Gravity of Beer");
        System.out.println("Final Gravity is 1.012");
        delegateExecution.setVariable("fg", 1.012);
    }
}
