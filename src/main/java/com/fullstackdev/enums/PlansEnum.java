package com.fullstackdev.enums;

/**
 * Created by nagla on 10/3/2016.
 */
public enum PlansEnum {
    BASIC(1,"BASIC_PLAN"),
    PRO(2,"PRO_PLAN");

    private final int id;
    private final String planName;

    PlansEnum(int id,String planName){
        this.id = id;
        this.planName=planName;
    }

    public int getId() {
        return id;
    }

    public String getPlanName() {
        return planName;
    }
}
