package com.polizas.polizas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

@Entity
@Table(name = "Polizas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Polizas {

    @Id
    @Column(name = "Id_Poliza")
    private Long idPolizas;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Fecha",nullable = false)
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "Empleado_Genero", nullable = false,foreignKey = @ForeignKey(name = "FK_EMPLEADO_GENERO"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "polizas"})
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "SKU",nullable = false,foreignKey = @ForeignKey(name = "FK_SKU_INVENTARIO"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "polizas"})
    private Inventario inventario;
}
