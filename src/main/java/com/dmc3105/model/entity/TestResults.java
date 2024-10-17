package com.dmc3105.model.entity;

import java.sql.Time;
import java.time.LocalTime;
import java.time.Period;

public class TestResults {
    
    private final int MAX_POINTS;
    private final int EARNED_POINTS;
    
    public TestResults(int maxPoints, int earnedPoints) {
        this.MAX_POINTS = maxPoints;
        this.EARNED_POINTS = earnedPoints;
    }
    
    public int getEarnedPoints() {
        return EARNED_POINTS;
    }
    
    public int getMaxPoints() {
        return MAX_POINTS;
    }
}
