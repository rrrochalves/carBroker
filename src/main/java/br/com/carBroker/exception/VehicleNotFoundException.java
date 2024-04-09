package br.com.carBroker.exception;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(Integer vehicleId) {
        super("O veiculo com id %d não existe!".formatted(vehicleId));
    }
}
