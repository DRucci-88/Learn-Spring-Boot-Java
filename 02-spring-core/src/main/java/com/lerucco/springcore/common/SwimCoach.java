package com.lerucco.springcore.common;

public class SwimCoach implements Couch{

    public SwimCoach() {
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim a 1000km as a warm up";
    }
}
