package com.swasth.smartlaundry.services;

import java.util.Date;
import java.util.Map;

import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.util.FireMessageEvent;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FcmService {

    @Autowired
    private FireMessageEvent fireMessageEvent;

    public Response fireMessage(String token) {

        String result = fireMessageEvent.sendToToken(token, "Dhobi dosth", "Wishes from Dhobi dosth");

        return Response.createSuccess(true, HttpStatus.OK.value(), "OK", result);

    }

    @Async
    public void fireMessage(String token, String msg, Map<String, String> orderData, int orderType) {

        JSONObject data = new JSONObject();
        data.put("title", "Dhobi dosth");
        data.put("image", "pick-up.png");
        data.put("message", msg);
        data.put("orderType", orderType);
        data.put("orderData", orderData);
        System.out.println(new Date());
        fireMessageEvent.sendToToken(token, data);
        System.out.println(new Date());

    }


    /*
     * public static void main(String[] args) {
     *
     *
     * FireMessageEvent fireMessageEvent=new FireMessageEvent(); String result=
     * fireMessageEvent.sendToToken(
     * "e5gWY5LtTK6APV8tOJKLG3:APA91bHD6shxWefHPs6mFyOzj_agGHUWDzqeS1OmoLXTnpcfWsJCjQdDwozY05eCq2mfj79BmpU8-M2dertqnCqGcqQDnoCaW3U2NXYWdhYFHGDZBOtZI7FktwspFgslQhi3qE8OC5-Q","Dhobi dosth"
     * ,"Hello world");
     *
     * System.out.println("result "+result); }
     */

}
