package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrimaryFermentationDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Initialing Primary Fermentation");
        // For ales 70 degrees and 7 days - for lagers 55 degrees and 1 day
        Integer fermentationTemp = 70;
        Integer fermentationTime = 7;
        Boolean isLager = (Boolean) delegateExecution.getVariable("lager");
        if (isLager) {
            fermentationTemp = 55;
            fermentationTime = 1;
        }
        System.out.println("Fermenting at " + fermentationTemp + " degrees F");
        for (int i = 0; i < fermentationTime; i++) {
            System.out.println("Fermentation Day " + i);
        }
        System.out.println("Primary Fermentation Complete");
    }
}
