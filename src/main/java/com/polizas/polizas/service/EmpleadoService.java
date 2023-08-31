package com.polizas.polizas.service;

import com.polizas.polizas.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> obtenerTodoslosEmpleados();

    public Empleado insertarEmepleado(Empleado empleado);
}
