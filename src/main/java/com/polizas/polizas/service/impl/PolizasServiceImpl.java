package com.polizas.polizas.service.impl;

import com.polizas.polizas.dto.*;
import com.polizas.polizas.model.Polizas;
import com.polizas.polizas.repository.PolizaRepository;
import com.polizas.polizas.service.PolizasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolizasServiceImpl implements PolizasService {

    private final PolizaRepository polizasRepository;

    public PolizasServiceImpl(PolizaRepository polizasRepository) {
        this.polizasRepository = polizasRepository;
    }


    @Override
    public List<Polizas> obtenerPolizas() {
        return polizasRepository.findAll();
    }

    @Override
    public Polizas crearPoliza(Polizas poliza) {
        return polizasRepository.save(poliza);
    }

    @Override
    public ResponseDTO consultarPolizaporId(Long idPoliza) {

        Optional<Polizas> polizaEncontrada = polizasRepository.findById(idPoliza);

        PolizaDTO polizaDTO = new PolizaDTO();
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        DetalleArticuloDTO detalleArticuloDTO = new DetalleArticuloDTO();
        PolizasEmpleadosDetalleDTO polizasEmpleadosDetalleDTO = new PolizasEmpleadosDetalleDTO();
        ResponseDTO responseDTO = new ResponseDTO();
        Meta meta = new Meta();
        if(polizaEncontrada.isPresent())
        {
            polizaDTO.setIdPoliza(polizaEncontrada.get().getIdPolizas());
            polizaDTO.setCantidad(polizaEncontrada.get().getCantidad());
            empleadoDTO.setNombre(polizaEncontrada.get().getEmpleado().getNombre());
            empleadoDTO.setApellido(polizaEncontrada.get().getEmpleado().getApellido());
            detalleArticuloDTO.setSku(polizaEncontrada.get().getInventario().getSku());
            detalleArticuloDTO.setNombreSku(polizaEncontrada.get().getInventario().getNombreSku());
            polizasEmpleadosDetalleDTO.setPoliza(polizaDTO);
            polizasEmpleadosDetalleDTO.setEmpleado(empleadoDTO);
            polizasEmpleadosDetalleDTO.setDetalleArticulo(detalleArticuloDTO);
            meta.setStatus("OK");
            responseDTO.setMeta(meta);
            responseDTO.setData(polizasEmpleadosDetalleDTO);
        }else{
            return new ResponseDTO();
        }


        return responseDTO;
    }
}
