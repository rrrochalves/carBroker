package br.com.carBroker.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "modelo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleModel {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "valor_FIPE", nullable = false)
    private Double fipeValue;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Brand brand;

}
