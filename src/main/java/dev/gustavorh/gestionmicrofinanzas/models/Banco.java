package dev.gustavorh.gestionmicrofinanzas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "bancos")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Long idBanco;

    @NotBlank
    @Size(min = 2, max = 100)
    private String nombre;

    @NotBlank
    @Size(min = 2)
    private String direccion;

    @NotBlank
    @Size(min = 3, max = 10)
    private String telefono;

    @NotBlank
    @Size(min = 3, max = 10)
    // TODO: Change to regex.
    private String email;

    @Column(name = "tasa_interes_base")
    @NotNull
    @Min(1)
    private Double tasaInteresBase;

    @OneToMany(mappedBy = "banco")
    private List<Prestamo> prestamos;

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long id_banco) {
        this.idBanco = id_banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getTasaInteresBase() {
        return tasaInteresBase;
    }

    public void setTasaInteresBase(Double tasaInteresBase) {
        this.tasaInteresBase = tasaInteresBase;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
