package com.uabc.proyecto.proyecto.service;

import com.uabc.proyecto.proyecto.model.Fproducto;
import com.uabc.proyecto.proyecto.model.Producto;
import com.uabc.proyecto.proyecto.repository.FproductoRepository;
import com.uabc.proyecto.proyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmaciaService {
    @Autowired
    private FproductoRepository repo;

    /**
     * Permite registrar Fprodutos
     * @return Fproducto registrado
     * @param Fproducto Fproducto a registrar
     */

    public Fproducto registrarFproducto(Fproducto fproducto){
        Fproducto fproductoSaved=repo.save(fproducto);
        return fproductoSaved;
    }
    //PROVIENE DE UN LISTADO
    public void actualizarFproducto(long id){
        Fproducto fproducto = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invelid producto Id:" + id));
        //TODO ENVIAR A LA VISTA HTML EL OBJETO A EDITAR CON UN MODEL
    }


    //ESTE USUARIO PROVIENE DE UN FORMULARIO DE EDICION
    public void actualizarFproducto(Fproducto fproducto){
        repo.save(fproducto);
    }

    public void eliminarFproducto(long id) {
        Fproducto fproducto = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid producto Id:" + id));
        repo.delete(fproducto);
    }
    public List<Fproducto> obtenerTodosFproducto(){
        List<Fproducto> actualList = new ArrayList<Fproducto>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }
    public Fproducto obtenerFproductoPorID(long id){
        return repo.findById(id).get();
    }
}
