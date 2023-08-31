package com.polizas.polizas.controller;

import com.polizas.polizas.dto.Meta;
import com.polizas.polizas.dto.ResponseDTO;
import com.polizas.polizas.model.Empleado;
import com.polizas.polizas.service.impl.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadosController {

    private final EmpleadoServiceImpl empleadoService;

    public EmpleadosController(EmpleadoServiceImpl empleadoService) {
        this.empleadoService = empleadoService;
    }


    @GetMapping("/saludo")
    public String saludo()
    {
        return "Saludo";
    }


    @GetMapping("/response")
    public ResponseDTO responseDTO()
    {
        ResponseDTO responseDTO = new ResponseDTO();
        Meta meta = new Meta("OK");
        responseDTO.setMeta(meta);
        responseDTO.setData(meta);
        return responseDTO;
    }

    @PostMapping("/AltaEmpleado")
    public Empleado crearEmpleado(@RequestBody Empleado empleado)
    {
        return empleadoService.insertarEmepleado(empleado);
    }

    @GetMapping("/todoslosEmpleados")
    public List<Empleado> obtenerTodosLosEmpleados()
    {
        return empleadoService.obtenerTodoslosEmpleados();
    }
}
