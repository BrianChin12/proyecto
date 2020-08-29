package com.uabc.proyecto.proyecto.service;

import com.uabc.proyecto.proyecto.model.Producto;
import com.uabc.proyecto.proyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repo;

    /**
     * Permite registrar Produtos
     * @return Producto registrado
     * @param Producto Producto a registrar
     */

    public Producto registrarProducto(Producto producto){
        Producto productoSaved=repo.save(producto);
        return productoSaved;
    }
    //PROVIENE DE UN LISTADO
    public void actualizarProducto(long id){
        Producto producto = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invelid producto Id:" + id));
        //TODO ENVIAR A LA VISTA HTML EL OBJETO A EDITAR CON UN MODEL
    }


    //ESTE USUARIO PROVIENE DE UN FORMULARIO DE EDICION
    public void actualizarProducto(Producto producto){
        repo.save(producto);
    }

    public void eliminarProducto(long id) {
        Producto producto = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid producto Id:" + id));
        repo.delete(producto);
    }
    public List<Producto> obtenerTodosProducto(){
        List<Producto> actualList = new ArrayList<Producto>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }
    public Producto obtenerProductoPorID(long id){
        return repo.findById(id).get();
    }
}
