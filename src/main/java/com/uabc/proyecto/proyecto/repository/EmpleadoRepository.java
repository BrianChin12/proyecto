package com.uabc.proyecto.proyecto.repository;

import com.uabc.proyecto.proyecto.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    List<Empleado> findByNombre(String nombre);
}
