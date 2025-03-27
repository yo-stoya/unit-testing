package com.dst;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestrictionService {
    List<Restriction> restrictions;
    List<Long> dates = List.of(
            new Date().toInstant().minus(3, ChronoUnit.DAYS).toEpochMilli(),
            new Date().toInstant().minus(12, ChronoUnit.HOURS).toEpochMilli(),
            new Date().toInstant().minus(10, ChronoUnit.HOURS).toEpochMilli(),
            new Date().toInstant().minus(5, ChronoUnit.HOURS).toEpochMilli(),
            new Date().toInstant().minus(20, ChronoUnit.HOURS).toEpochMilli()
    );


    public RestrictionService() {
        restrictions = new ArrayList<>();
        restrictions.add(new Restriction("login", new Date())); // now
        dates.forEach(date -> restrictions.add(new Restriction("login", new Date(date))));
    }

    public int countResolvedAt(Date time) {
        int count = 0;
        List<Restriction> resolvedAfter = new ArrayList<>();
        long fromTime = System.currentTimeMillis() - time.getTime();
        Date offset = new Date(fromTime - fromTime % 1000);
        for (Restriction restriction : restrictions) {
            if (restriction.getResolvedAt().getTime() > offset.getTime()) {
                count++;
                System.out.println("resolved at: " + restriction.getResolvedAt() + " > " + time);
                resolvedAfter.add(restriction);
            } else {
                count = 0;
            }
        }


        return count;
    }

    public boolean isHangry() {
        return true;
    }
}
