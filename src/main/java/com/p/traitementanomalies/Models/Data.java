package com.p.traitementanomalies.Models;

import java.util.ArrayList;

public class Data {
    private String nAnomalie;
    private String dateHour;
    private String department;
    private String nLot;
    private String type;
    private String subType;
    private String fullName;

    public Data(String fullName, String nAnomalie, String dateHour, String department, String nLot, String type, String subType) {
        this.fullName = fullName;
        this.nAnomalie = nAnomalie;
        this.dateHour = dateHour;
        this.department = department;
        this.nLot = nLot;
        this.type = type;
        this.subType = subType;
    }

    public String getnAnomalie() {
        return nAnomalie;
    }

    public void setnAnomalie(String nAnomalie) {
        this.nAnomalie = nAnomalie;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getnLot() {
        return nLot;
    }

    public void setnLot(String nLot) {
        this.nLot = nLot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
