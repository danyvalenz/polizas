package com.polizas.polizas.service;


import com.polizas.polizas.model.Inventario;

import java.util.List;

public interface InventarioService {

    public List<Inventario> obtenerInventario();

    public Inventario insertarCodigoenInventario(Inventario inventario);
}
