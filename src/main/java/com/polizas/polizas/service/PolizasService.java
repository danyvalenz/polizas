package com.polizas.polizas.service;

import com.polizas.polizas.dto.PolizasEmpleadosDetalleDTO;
import com.polizas.polizas.dto.ResponseDTO;
import com.polizas.polizas.model.Inventario;
import com.polizas.polizas.model.Polizas;

import java.util.List;

public interface PolizasService {

    public List<Polizas> obtenerPolizas();

    public Polizas crearPoliza(Polizas poliza);

    public ResponseDTO consultarPolizaporId(Long idPoliza);

    public String elimiarPoliza(Long poliza);

}
