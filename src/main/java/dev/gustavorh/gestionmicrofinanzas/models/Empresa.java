package dev.gustavorh.gestionmicrofinanzas.models;

import dev.gustavorh.gestionmicrofinanzas.enums.Estado;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long idEmpresa;

    private String nombre;

    private String direccion;

    private String telefono;

    private String email;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "empresa")
    private List<Prestamo> prestamos;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String telefono, String email, Date fechaRegistro, Estado estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
