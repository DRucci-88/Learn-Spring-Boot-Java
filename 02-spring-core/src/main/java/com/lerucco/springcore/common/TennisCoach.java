package com.lerucco.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Couch {
    public TennisCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}