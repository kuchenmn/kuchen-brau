package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrepareYeastDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Boolean dryYeast = false;
        String recipe = (String) delegateExecution.getVariable("recipeName");

        if (recipe.contains("IPA")) {  // TODO: this should be a decision table
            dryYeast = true;
        }
        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("yeastRequestMessage")
                .setVariable("dryYeast", dryYeast).correlate();
    }
}
