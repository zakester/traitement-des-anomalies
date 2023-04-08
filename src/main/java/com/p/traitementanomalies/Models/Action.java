package com.p.traitementanomalies.Models;

import java.util.ArrayList;

public class Action {

    private ActionType actionType;
    private String action;
    private ArrayList<String> errorCause;

    public Action(ActionType actionType, String action, ArrayList<String> errorCause) {
        this.actionType = actionType;
        this.action = action;
        this.errorCause = errorCause;
    }

    public Action(ActionType actionType, String action) {
        this.actionType = actionType;
        this.action = action;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ArrayList<String> getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(ArrayList<String> errorCause) {
        this.errorCause = errorCause;
    }

}
