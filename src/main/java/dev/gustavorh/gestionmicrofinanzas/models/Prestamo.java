package dev.gustavorh.gestionmicrofinanzas.models;

import dev.gustavorh.gestionmicrofinanzas.enums.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "prestamos")
public class Prestamo extends BaseEntity {
    @Column(nullable = false)
    @NotNull
    @Min(1000)
    private Double montoSolicitado;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Double tasaInteres;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer plazoMeses;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    @NotNull
    private Date fechaSolicitud;

    @Column(nullable = false)
    @NotNull
    private Date fechaAprobacion;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;

    @OneToMany(mappedBy = "prestamo")
    private List<Pago> pagos;
}
