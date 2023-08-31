package com.polizas.polizas.repository;

import com.polizas.polizas.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventariosRepository extends JpaRepository<Inventario,Long> {
}
