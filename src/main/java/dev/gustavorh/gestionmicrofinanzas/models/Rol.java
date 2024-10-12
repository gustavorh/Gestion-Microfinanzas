package dev.gustavorh.gestionmicrofinanzas.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "roles")
public class Rol extends BaseEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String nombre;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2)
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Usuario> usuarios;

    public Rol() {
        this.usuarios = new ArrayList<>();
    }
}
