package br.com.carBroker.exception;

public class BrandNotFoundException extends RuntimeException {

    public BrandNotFoundException(Integer id) {
        super("Marca com id %d não encontrada!".formatted(id));
    }
}
