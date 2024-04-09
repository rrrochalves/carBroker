package br.com.carBroker.domain.model;


import br.com.carBroker.domain.enums.Fuel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "timestamp_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;

    @Column(name = "ano", nullable = false)
    private Integer year;

    @Column(name = "combustivel", nullable = false)
    private Fuel fuel;

    @Column(name = "num_portas", nullable = false)
    private Integer numberOfDoors;

    @Column(name = "cor", nullable = false)
    private String color;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private VehicleModel model;

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
    }
}
