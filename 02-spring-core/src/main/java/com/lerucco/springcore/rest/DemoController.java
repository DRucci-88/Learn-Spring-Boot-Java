package com.lerucco.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lerucco.springcore.common.Couch;

@RestController
public class DemoController {
    // define private field for dependency
    private Couch couch;
    private Couch anotherCouch;

    // define constructor for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("aquatic") Couch couch,
            @Qualifier("cricketCoach") Couch anotherCouch) {
        System.out.println("In constructor : " + getClass().getSimpleName());
        this.couch = couch;
        this.anotherCouch = anotherCouch;
    }

    // Qualifiers
    // @Autowired
    // public DemoController(@Qualifier("trackCoach") Couch couch) {
    // this.myCouch = couch;
    // }

    // Setter injection
    // @Autowired
    // public void setCoach(Couch theCouch) {
    // myCouch = theCouch;
    // }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return couch.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans myCoach == myOtherCoach " + (couch == anotherCouch);
    }
}
