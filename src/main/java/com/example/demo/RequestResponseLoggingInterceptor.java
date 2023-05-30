package com.example.demo;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        System.out.println("=========================== REQUEST ===========================");
        System.out.println("URI         : " + request.getURI());
        System.out.println("Method      : " + request.getMethod());
        System.out.println("Headers     : " + request.getHeaders());
        System.out.println("Request body: " + new String(body, Charset.defaultCharset()));
        System.out.println("==============================================================");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        System.out.println("=========================== RESPONSE ===========================");
        System.out.println("Status code  : " + response.getStatusCode());
        System.out.println("Headers      : " + response.getHeaders());
        System.out.println("Response body: " + StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        System.out.println("==============================================================");
    }
}

