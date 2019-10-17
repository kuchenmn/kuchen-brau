package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AddHopsDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Preparing to add Hops");
        System.out.println("Adding bittering hops");
//        Thread.sleep(45000);
        System.out.println("Adding flavoring hops");
//        Thread.sleep(10000);
        System.out.println("Adding aroma hops");
        System.out.println("Hop Additions Complete");
    }
}
