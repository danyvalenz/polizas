package com.polizas.polizas.controller;

import com.polizas.polizas.model.Inventario;
import com.polizas.polizas.service.impl.InventarioServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventarioController {

    private final InventarioServiceImpl inventarioService;

    public InventarioController(InventarioServiceImpl inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/obtenerInventario")
    public List<Inventario> obtenerInventario()
    {
        return inventarioService.obtenerInventario();
    }


    @PostMapping("/altaCodigo")
    public Inventario altaCodigo(@RequestBody Inventario inventario)
    {
        return inventarioService.insertarCodigoenInventario(inventario);
    }
}
