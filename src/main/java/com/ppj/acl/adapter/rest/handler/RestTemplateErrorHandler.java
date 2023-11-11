package com.ppj.acl.adapter.rest.handler;

import com.ppj.acl.adapter.rest.exception.RestClientGenericException;
import com.ppj.acl.config.ErrorCodeAccount;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
public class RestTemplateErrorHandler implements ResponseErrorHandler {
    private final Map<HttpStatus, RuntimeException> exceptionMap;

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw exceptionMap.getOrDefault(response.getStatusCode(), new RestClientGenericException(ErrorCodeAccount.WEB_CLIENT_GENERIC));
    }
}
