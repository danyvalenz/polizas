package com.polizas.polizas.controller;

import com.polizas.polizas.dto.ResponseDTO;
import com.polizas.polizas.model.Polizas;
import com.polizas.polizas.service.impl.PolizasServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PolizasController {

    private final PolizasServiceImpl polizasService;

    public PolizasController(PolizasServiceImpl polizasService) {
        this.polizasService = polizasService;
    }


    @GetMapping("/todaslasPolizas")
    public List<Polizas> todasLasPolizas()
    {
        return polizasService.obtenerPolizas();
    }

    @PostMapping("/crearPoliza")
    public Polizas crearPoliza(@RequestBody Polizas poliza)
    {

        return polizasService.crearPoliza(poliza);
    }

    @GetMapping("/consultar/{idpoliza}")
    public ResponseDTO consultarpolizaporID(@PathVariable("idpoliza") Long idPoliza)
    {
        return polizasService.consultarPolizaporId(idPoliza);
    }

    @DeleteMapping("/eliminar/{idpoliza}")
    public String eliminarExito(@PathVariable("idpoliza") Long idPoliza)
    {

        return polizasService.elimiarPoliza(idPoliza);
    }
}
