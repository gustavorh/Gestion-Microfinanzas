package dev.gustavorh.gestionmicrofinanzas.models;

import dev.gustavorh.gestionmicrofinanzas.enums.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "empresas")
public class Empresa extends BaseEntity {
    @Column(nullable = false, length = 100)
    @NotBlank
    @Size(min = 2, max = 100)
    private String nombre;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2)
    private String direccion;

    @Column(nullable = false, length = 10)
    @NotBlank
    @Size(min = 3, max = 10)
    private String telefono;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 10)
    // TODO: Change to regex.
    private String email;

    @Column(nullable = false)
    @NotNull
    private Date fechaRegistro;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "empresa")
    private List<Prestamo> prestamos;
}
