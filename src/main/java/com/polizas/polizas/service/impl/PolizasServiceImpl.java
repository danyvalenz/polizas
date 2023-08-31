package com.polizas.polizas.service.impl;

import com.polizas.polizas.dto.*;
import com.polizas.polizas.model.Inventario;
import com.polizas.polizas.model.Polizas;
import com.polizas.polizas.repository.InventariosRepository;
import com.polizas.polizas.repository.PolizaRepository;
import com.polizas.polizas.service.PolizasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolizasServiceImpl implements PolizasService {

    private final PolizaRepository polizasRepository;
    private final InventariosRepository inventariosRepository;

    @Autowired
    public PolizasServiceImpl(PolizaRepository polizasRepository, InventariosRepository inventariosRepository) {
        this.polizasRepository = polizasRepository;
        this.inventariosRepository = inventariosRepository;
    }


    @Override
    public List<Polizas> obtenerPolizas() {
        return polizasRepository.findAll();
    }

    @Override
    public Polizas crearPoliza(Polizas poliza) {

       Optional<Inventario> inventario = inventariosRepository.findById(poliza.getInventario().getSku());
       if(inventario.isPresent())
       {
           //proceso que se encarga de descontar la cantidad del inventario
           Inventario inv = inventario.get();
           Integer cantidadDescontar = inventario.get().getCantidad() - poliza.getCantidad();
           inv.setCantidad(cantidadDescontar);
           inventariosRepository.save(inv);
       }

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

    @Override
    public String elimiarPoliza(Long poliza) {
        Optional<Polizas> polizasOptional = polizasRepository.findById(poliza);
        if (polizasOptional.isPresent())
        {
            Polizas polizaEliminar = polizasOptional.get();
            Integer cantidaRegresaInventario = polizaEliminar.getCantidad();
            Optional<Inventario> inventarioOptional = inventariosRepository.findById(polizaEliminar.getInventario().getSku());
            if (inventarioOptional.isPresent())
            {
                Inventario inventarioActualizar = inventarioOptional.get();
                inventarioActualizar.setCantidad(inventarioActualizar.getCantidad()+cantidaRegresaInventario);
                inventariosRepository.save(inventarioActualizar);
            }
            polizasRepository.delete(polizaEliminar);
            return "Poliza eliminada con exito";
        }else {
            return "Poliza No encontrada";
        }

    }
}
