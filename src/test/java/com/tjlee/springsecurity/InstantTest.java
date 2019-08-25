package com.tjlee.springsecurity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantTest {

    public static void main(String[] args) {
        Instant instant = Instant.now();

        System.out.println(instant.getEpochSecond());
        System.out.println();

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);
    }
}
