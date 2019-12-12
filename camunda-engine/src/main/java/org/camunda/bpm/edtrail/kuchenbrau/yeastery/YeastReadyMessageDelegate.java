package org.camunda.bpm.edtrail.kuchenbrau.yeastery;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class YeastReadyMessageDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Map<String, Object> variables = new HashMap<>();
        variables.put("yeastTempreature", delegateExecution.getVariable("yeastTemperature"));
        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("yeastReadyMessage")
                .processInstanceBusinessKey(delegateExecution.getProcessBusinessKey())
                .setVariables(variables).correlate();
    }
}
