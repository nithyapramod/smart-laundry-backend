package com.swasth.smartlaundry.util;

import java.util.UUID;

public class UuidGenarator {

    public static String gen(String prefix) {
        UUID uuid = UUID.randomUUID();
        StringBuffer buffer = new StringBuffer().append(prefix).append(uuid.toString().replaceAll("-", ""));
        return buffer.toString();
    }

    public static String transactionGen(String prefix) {
        Snowflake snowflake = new Snowflake.Builder(12).build();
        StringBuffer buffer = new StringBuffer().append(prefix).append(snowflake.nextId());
        return buffer.toString();

    }

}
