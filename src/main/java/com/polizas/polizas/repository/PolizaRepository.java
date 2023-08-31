package com.polizas.polizas.repository;

import com.polizas.polizas.model.Polizas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaRepository extends JpaRepository<Polizas,Long> {
}
