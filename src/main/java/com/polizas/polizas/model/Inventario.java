package com.polizas.polizas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    @Id
    @Column(name = "SKU")
    private Long sku;

    @Column(name = "Nombre")
    private String nombreSku;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @OneToMany(mappedBy = "inventario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "inventario"})
    private List<Polizas> polizas = new ArrayList<>();
}
