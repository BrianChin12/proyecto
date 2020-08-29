package com.uabc.proyecto.proyecto.repository;

import com.uabc.proyecto.proyecto.model.Fproducto;
import com.uabc.proyecto.proyecto.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FproductoRepository extends CrudRepository<Fproducto, Long> {
    List<Fproducto> findByNombre(String nombre);
}
