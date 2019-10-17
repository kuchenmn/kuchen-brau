package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrepareExtractDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating extract preparation");
        System.out.println("Adding malt extract");
        System.out.println("Adding H2O");
        System.out.println("Initiating stir sequence");
        System.out.println("Extract preparation complete");
    }
}
