package com.lerucco.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Couch {
    public TrackCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run 5 Km";
    }
}
