package com.dst;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RestrictionService restrictionService = new RestrictionService();
        Date last24Hours = Date.from(Instant.now().minus(24, ChronoUnit.HOURS));
        long twentyFourHoursAgoMillis = System.currentTimeMillis() - (24 * 60 * 60 * 1000); // 24 hours
        // truncate to seconds for Oracle DATE precision
        long truncatedTime = (twentyFourHoursAgoMillis / 1000) * 1000;

        System.out.println(last24Hours.getTime());
        System.out.println(twentyFourHoursAgoMillis);
        System.out.println(truncatedTime);


    }
}
