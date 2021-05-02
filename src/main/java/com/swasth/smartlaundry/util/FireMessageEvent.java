package com.swasth.smartlaundry.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FireMessageEvent implements Serializable {

    private static final long serialVersionUID = -657425887855883947L;

    @Value("${fcm.server.key}")
    private String serverKey;

    @Value("${fcm.server.api}")
    private String fcmApi;

    private final JSONObject root = new JSONObject();

    public String sendToTopic(String topic) throws Exception { // SEND TO TOPIC
        System.out.println("Send to Topic");
        root.put("condition", "'" + topic + "' in topics");
        return sendPushNotification(true);
    }

    public String sendToGroup(JSONArray mobileTokens) throws Exception { // SEND TO GROUP OF PHONES - ARRAY OF TOKENS
        root.put("registration_ids", mobileTokens);
        root.put("content_available", true);
        root.put("mutable_content", true);

        return sendPushNotification(false);
    }

    public String sendToToken(String token, JSONObject data) {// SEND MESSAGE TO SINGLE MOBILE - TO TOKEN
        root.put("to", token);
        root.put("content_available", true);
        root.put("mutable_content", true);
        root.put("data", data);
        return sendPushNotification(false);
    }

    public String sendToToken(String token, String title, String message) {// SEND MESSAGE TO SINGLE MOBILE - TO TOKEN
        root.put("to", token);
        root.put("content_available", true);
        root.put("mutable_content", true);
        JSONObject data = new JSONObject();
        data.put("title", title);
        data.put("message", message);
        root.put("data", data);
        return sendPushNotification(false);
    }

    private String sendPushNotification(boolean toTopic) {
        try {
            URL url = new URL(fcmApi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "key=" + serverKey);

            System.out.println(root.toString());


            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(root.toString());
            wr.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder builder = new StringBuilder();
            while ((output = br.readLine()) != null) {
                builder.append(output);
            }
            System.out.println(builder);
            String result = builder.toString();

            JSONObject obj = new JSONObject(result);

            if (toTopic) {
                if (obj.has("message_id")) {
                    return "SUCCESS";
                }
            } else {
                int success = obj.getInt("success");
                if (success > 0) {
                    return "SUCCESS";
                }
            }

            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
}