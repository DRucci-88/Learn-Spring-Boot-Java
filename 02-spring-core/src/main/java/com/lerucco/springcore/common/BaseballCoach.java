package com.lerucco.springcore.common;

import org.springframework.stereotype.Component;

@Component
// @Lazy
public class BaseballCoach implements Couch {

    public BaseballCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
