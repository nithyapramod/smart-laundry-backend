package com.swasth.smartlaundry.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

@Component
public class SMSSender {

    public String sendSms(String phoneNumber, String msg) {
        try {
// Construct data
            // String phonenumbers = "9494005552";
            String data = "user=" + URLEncoder.encode("someshgp", StandardCharsets.UTF_8);
            data += "&password=" + URLEncoder.encode("pramu@sms", StandardCharsets.UTF_8);
            data += "&message=" + URLEncoder.encode(msg, StandardCharsets.UTF_8);
            data += "&sender=" + URLEncoder.encode("DDOSTH", StandardCharsets.UTF_8);
            data += "&mobile=" + URLEncoder.encode(phoneNumber, StandardCharsets.UTF_8);
            data += "&type=" + URLEncoder.encode("3", StandardCharsets.UTF_8);
// Send data 
            URL url = new URL("http://login.bulksmsgateway.in/sendmessage.php?" + data);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
// Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String sResult1 = "";
            while ((line = rd.readLine()) != null) {
// Process line...
                sResult1 = sResult1 + line + " ";
            }
            wr.close();
            rd.close();
            return sResult1;
        } catch (Exception e) {
            System.out.println("Error SMS " + e);
            return "Error " + e;
        }
    }
}
