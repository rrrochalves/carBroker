package br.com.carBroker.exception;

public class VehicleModelNotFoundException extends RuntimeException {

    public VehicleModelNotFoundException(Integer id) {
        super("Modelo do veiculo com id %d não encontrado!".formatted(id));
    }
}
