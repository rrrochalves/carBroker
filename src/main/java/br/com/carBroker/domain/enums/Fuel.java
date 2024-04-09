package br.com.carBroker.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Fuel {

    FLEX("flex"),
    ALCOOL("alcool"),
    GASOLINA("gasolina");

    private final String value;

}
