package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

public class PrepareYeastDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Boolean dryYeast = (Boolean) delegateExecution.getVariable("dryYeast");
        String recipe = (String) delegateExecution.getVariable("recipeName");

        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put("dryYeast", dryYeast);
        delegateExecution.getProcessEngineServices().getRuntimeService()
                .startProcessInstanceByMessage("yeastRequestMessage", delegateExecution.getProcessBusinessKey(), processVariables);
    }
}
