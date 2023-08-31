package com.polizas.polizas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    @Column(name = "Id_Empleado")
    private Long idEmpleado;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Puesto")
    private String puesto;

    @OneToMany(mappedBy = "empleado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "empleado"})
    private List<Polizas> polizas = new ArrayList<>();


}
