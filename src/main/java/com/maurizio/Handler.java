package com.maurizio;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.*;
import java.util.Map;


public class Handler implements RequestHandler<Map<String, String>, Void> {

    @Override
    public Void handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        for (Map.Entry<String, String> entry : event.entrySet()) {
            logger.log(entry.getKey() + " " + entry.getValue());
        }
        return null;
    }
}