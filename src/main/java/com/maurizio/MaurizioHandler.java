package com.maurizio;

import com.amazonaws.services.lambda.runtime.RequestHandler;

interface MaurizioHandler<I, O> extends RequestHandler<I, O> {
}
