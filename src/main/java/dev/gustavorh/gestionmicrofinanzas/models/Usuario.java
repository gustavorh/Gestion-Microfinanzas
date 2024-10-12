package dev.gustavorh.gestionmicrofinanzas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "usuarios")
public class Usuario extends BaseEntity {
    @Column(name = "usuario", unique = true, nullable = false, length = 20)
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombreUsuario;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 6, max = 100)
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @Transient
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
