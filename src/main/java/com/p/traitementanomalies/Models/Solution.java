package com.p.traitementanomalies.Models;

import java.util.ArrayList;

public class Solution {

    private String anomalies;
    private ArrayList<Action> corrective, preventive;

    public Solution(String anomalies, ArrayList<Action> corrective, ArrayList<Action> preventive) {
        this.anomalies = anomalies;
        this.corrective = corrective;
        this.preventive = preventive;
    }

    public String getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(String anomalies) {
        this.anomalies = anomalies;
    }

    public ArrayList<Action> getCorrective() {
        return corrective;
    }

    public void setCorrective(ArrayList<Action> corrective) {
        this.corrective = corrective;
    }

    public ArrayList<Action> getPreventive() {
        return preventive;
    }

    public void setPreventive(ArrayList<Action> preventive) {
        this.preventive = preventive;
    }
}