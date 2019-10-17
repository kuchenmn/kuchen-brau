package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BoilWortDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating wort boiling phase");
        System.out.println("Heating wort to boiling temperature");
        System.out.println("Holding at boil");
//        Thread.sleep(60000); // 1 min
        System.out.println("Boiling Complete");
    }
}
