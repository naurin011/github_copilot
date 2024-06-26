package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClockworkTown {

    private final LocalTime grandClockTime;
    private final Map<LocalTime, Long> clockDifferences;

    public ClockworkTown(LocalTime grandClockTime) {
        this.grandClockTime = grandClockTime;
        this.clockDifferences = new HashMap<>();
    }
    public LocalTime getGrandClockTime() {
        return grandClockTime;
    }

    public long calculateTimeDifference(LocalTime clock) {
        return Duration.between(grandClockTime, clock).toMinutes();
    }

    // this function calculates the time difference for each clock in the town from the grand clock time
    public void clockDifferenceCalculator(List<LocalTime> clocks) {
        System.out.println("Calculating the time difference for each clock in the town from the grand clock time: " + grandClockTime);
        for (LocalTime clock : clocks) {
            Long difference = calculateTimeDifference(clock);
            clockDifferences.put(clock, difference);
            System.out.println("Clock: " + clock + " Time difference in min: " + difference + " minutes");
        }

    }

    public static void main(String[] args) {
        ClockworkTown clockworkTown = new ClockworkTown(LocalTime.now());
        System.out.println("Grand Clock Time: " + clockworkTown.getGrandClockTime());
        clockworkTown.clockDifferenceCalculator(List.of(LocalTime.of(10, 0), LocalTime.of(20, 0), LocalTime.of(3, 0)));
    }
}