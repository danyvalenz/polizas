package com.polizas.polizas.service.impl;

import com.polizas.polizas.model.Inventario;
import com.polizas.polizas.repository.InventariosRepository;
import com.polizas.polizas.service.InventarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventariosRepository inventariosRepository;

    public InventarioServiceImpl(InventariosRepository inventariosRepository) {
        this.inventariosRepository = inventariosRepository;
    }

    @Override
    public List<Inventario> obtenerInventario() {
        return inventariosRepository.findAll();
    }

    @Override
    public Inventario insertarCodigoenInventario(Inventario inventario) {
        return inventariosRepository.save(inventario);
    }
}
