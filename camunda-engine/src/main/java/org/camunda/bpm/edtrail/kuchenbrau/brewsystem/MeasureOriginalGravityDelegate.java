package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MeasureOriginalGravityDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Measuring Original Gravity of Wort");
        System.out.println("Original Gravity is 1.058");
        delegateExecution.setVariable("og", 1.048);
    }
}
