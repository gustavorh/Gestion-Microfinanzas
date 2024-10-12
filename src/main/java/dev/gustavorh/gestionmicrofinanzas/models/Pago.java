package dev.gustavorh.gestionmicrofinanzas.models;

import dev.gustavorh.gestionmicrofinanzas.enums.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "pagos")
public class Pago extends BaseEntity {
    @Column(nullable = false)
    @NotNull
    @Min(1000)
    private Double monto;

    @Column(nullable = false)
    @NotNull
    private Date fechaPago;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "prestamo_id")
    private Prestamo prestamo;
}
