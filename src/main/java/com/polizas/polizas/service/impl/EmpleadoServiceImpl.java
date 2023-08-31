package com.polizas.polizas.service.impl;

import com.polizas.polizas.model.Empleado;
import com.polizas.polizas.repository.EmpleadoRepository;
import com.polizas.polizas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> obtenerTodoslosEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado insertarEmepleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
