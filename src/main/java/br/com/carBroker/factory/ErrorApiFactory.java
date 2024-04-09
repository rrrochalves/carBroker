package br.com.carBroker.factory;

import br.com.carBroker.config.ErrorApi;

public class ErrorApiFactory {

    public static ErrorApi build(String message) {
        return ErrorApi.builder()
                .message(message)
                .build();
    }
}
