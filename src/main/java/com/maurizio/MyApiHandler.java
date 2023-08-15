package com.maurizio;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;


public class MyApiHandler implements RequestHandler<Map<String, String>, Integer> {

    @Override
    public Integer handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        for (Map.Entry<String, String> entry : event.entrySet()) {
            logger.log(entry.getKey() + " " + entry.getValue());
        }
        return 1000;
    }
}