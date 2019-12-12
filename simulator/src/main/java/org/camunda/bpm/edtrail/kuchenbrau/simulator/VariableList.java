package org.camunda.bpm.edtrail.kuchenbrau.simulator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableList {
    private List<TaskVariable> taskVariables;

    public VariableList() {}

    public List<TaskVariable> getTaskIds() {
        return taskVariables;
    }

    public void setTaskIds(List<TaskVariable> taskVariables) {
        this.taskVariables = taskVariables;
    }

//    @Override
//    public String toString() {
//        String returnString = "";
//        for (TaskVariable taskVariable : taskVariables) {
//            returnString.concat("ID:" + taskVariable.getId() + "---");
//        }
//        return returnString;
//    }
}
