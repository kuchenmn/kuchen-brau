package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DiacetylRestDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initiating Diacetyl Rest");
        System.out.println("Warming wort");
//        Thread.sleep(60000); // 1 min
        System.out.println("Diacetyl Rest Complete");
    }
}
