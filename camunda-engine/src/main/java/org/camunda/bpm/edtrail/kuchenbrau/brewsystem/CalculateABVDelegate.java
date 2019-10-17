package org.camunda.bpm.edtrail.kuchenbrau.brewsystem;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CalculateABVDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // ABV=(OG-FG)*131
        System.out.println("Calculating ABV");
        double og = (Double) delegateExecution.getVariable("og");
        double fg = (Double) delegateExecution.getVariable("fg");
        double abv = (og - fg) * 131;
        System.out.println("The ABV is calculated at " + abv + "%");
        delegateExecution.setVariable("abv", abv);
    }
}
