package com.swasth.smartlaundry.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Timslots {

    public static void main(String[] args) throws ParseException {

        Map<Integer, Integer> s = new HashMap<Integer, Integer>();
        s.put(9, 1);
        s.put(10, 2);
        s.put(11, 3);
        s.put(12, 4);
        s.put(13, 5);
        s.put(14, 5);
        s.put(15, 5);
        s.put(16, 6);
        s.put(17, 7);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss");

        String ds = "2020-06-18T10:26:52";
        Date date = df.parse(ds);
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String shortTimeStr = sdf.format(date);

        Integer sss = s.get(Integer.valueOf(shortTimeStr));


        System.out.println(sss);

    }

}
