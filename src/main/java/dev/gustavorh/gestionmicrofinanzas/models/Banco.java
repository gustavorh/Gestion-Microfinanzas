package dev.gustavorh.gestionmicrofinanzas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "bancos")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Long idBanco;

    private String nombre;

    private String direccion;

    private String telefono;

    private String email;

    @Column(name = "tasa_interes_base")
    private Double tasaInteresBase;

    @OneToMany(mappedBy = "banco")
    private List<Prestamo> prestamos;

    public Banco() {
    }

    public Banco(String nombre, String direccion, String telefono, String email, Double tasaInteresBase) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tasaInteresBase = tasaInteresBase;
    }

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
}
