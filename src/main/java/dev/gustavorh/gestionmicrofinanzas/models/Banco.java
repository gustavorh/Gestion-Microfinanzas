package dev.gustavorh.gestionmicrofinanzas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "bancos")
public class Banco extends BaseEntity {
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(min = 2)
    @Column(nullable = false)
    private String direccion;

    @NotBlank
    @Size(min = 3, max = 10)
    @Column(nullable = false)
    private String telefono;

    @NotBlank
    @Email
    @Column(nullable = false)
    // TODO: Change to regex.
    private String email;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Double tasaInteresBase;

    @OneToMany(mappedBy = "banco")
    private List<Prestamo> prestamos;
}
